package com.example.esdemo.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Auther: 陈仁水
 * @Date: 2018-11-27 10:51
 * @Description 初始化数据源
 * @Configuration 标识这个类可以使用Spring IoC容器作为bean定义的来源，配置信息的载体由XML文件转移到了Java类中
 * @EnableConfigurationProperties 注解使@ConfigurationProperties生效，并从IOC容器中获取bean
 * @ConditionalOnClass 判断当前classpath下是否存在指定类，若是则将当前的配置装载入spring容器
 * @ConditionalOnProperty 检查指定属性是否具有特定值的条件,如果返回值为false，则该configuration不生效；为true则生效。
 * @AutoConfigureBefore 自动注入在什么类加载之前
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "jdbc", name = "url")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {

    @Autowired
    private DruidProperties properties;

    @Autowired
    WallFilter wallFilter;

    @Bean
    public DataSource dataSource() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        System.out.println("==================" + properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(ConfigTools.decrypt(properties.getPublickey(), properties.getPassword()));
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setValidationQuery(properties.getValidationQuery());
        // 装载过滤器和防火墙
        // dataSource.setFilters("stat,wall");
        List<Filter> filters = new ArrayList<>();
        filters.add(wallFilter);
        dataSource.setProxyFilters(filters);
        // 合并多个DruidDataSource的监控数据
        dataSource.setUseGlobalDataSourceStat(true);
        Properties p = new Properties();
        p.setProperty("druid.stat.mergeSql","true");
        p.setProperty("druid.stat.slowSqlMillis","5000");
        dataSource.setConnectProperties(p);
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        // bean.addInitParameter("allow","127.0.0.1");
        bean.addInitParameter("resetEnable","false");
        bean.addInitParameter("loginUsername","yeion");
        bean.addInitParameter("loginPassword","yeion1881");
        return bean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions","*.js,*.gif,/druid/*");
        return bean;
    }

    @Bean(name = "wallFilter")
    @DependsOn("wallConfig")
    public WallFilter wallFilter(WallConfig wallConfig){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);
        return wallFilter;
    }

    @Bean(name = "wallConfig")
    public WallConfig wallConfig(){
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);//允许一次执行多条语句
        wallConfig.setNoneBaseStatementAllow(true);//允许一次执行多条语句
        return wallConfig;
    }
}
