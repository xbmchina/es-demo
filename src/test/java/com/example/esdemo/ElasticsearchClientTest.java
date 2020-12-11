package com.example.esdemo;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.esdemo.dao.OrderMapper;
import com.example.esdemo.dao.ShopBuyerMapper;
import com.example.esdemo.dao.TradeMapper;
import com.example.esdemo.entity.Order;
import com.example.esdemo.entity.ShopBuyer;
import com.example.esdemo.entity.Trade;
import com.github.pagehelper.PageHelper;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：xbm
 * @date ：Created in 2020/12/11 9:54
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchClientTest {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    String index = "shop_buyer";

    @Autowired
    TradeMapper tradeMapper;


    @Autowired
    OrderMapper orderMapper;


    @Autowired
    ShopBuyerMapper shopBuyerMapper;

    /**
     * 创建索引
     *
     * @throws IOException
     */
    @Test
    public void createIndex() throws IOException {
        CreateIndexRequest indexRequest = new CreateIndexRequest(index);
        CreateIndexResponse response = restHighLevelClient.indices()
                .create(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }

    /**
     * 判断索引是否存在
     *
     * @throws IOException
     */
    @Test
    public void indexExists() throws IOException {
        GetIndexRequest request = new GetIndexRequest(index);
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 添加文档
     *
     * @throws IOException
     */
    @Test
    public void addDoc() throws IOException {
        IndexRequest request = new IndexRequest(index);
        Trade trade = Trade.Builder.aTrade()
                .buyerAlipayNo("13652878074")
                .buyerMessage("helloworder")
                .buyerNick("xbmchina")
                .consignTime(new Date())
                .created(new Date())
                .discountFee(2.56)
                .endTime(new Date())
                .lastSendTime(new Date())
                .lastShippingUpdateTime(new Date())
                .modified(new Date())
                .num(2)
                .payTime(new Date())
                .postFee(24.12)
                .price(399.59)
                .receivedPayment(399.59)
                .receiverAddress("广东省广州市黄埔大道中")
                .receiverName("小明同学")
                .sellerId(11l)
                .shopBuyerId(2121l)
                .build();
        String source = JSONObject.toJSONString(trade);
        // 手动设置id
//        request.id("10000");
        request.source(source, XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }


    /**
     * 批量添加文档
     */
    @Test
    public void batchAddTradeDoc() throws IOException {
        int pageNum = 1;
        int pageSize = 10000;
        while (true) {
            System.out.println("pageNum=" + pageNum + "|pageSize=" + pageSize);
            BulkRequest bulkRequest = new BulkRequest();
            PageHelper.startPage(pageNum, pageSize);
            List<Trade> tradeList = tradeMapper.selectList(new QueryWrapper<Trade>().eq("seller_id", 50007471));
            if (CollectionUtils.isEmpty(tradeList)) {
                break;
            }
            for (Trade trade : tradeList) {
                IndexRequest indexRequest = new IndexRequest(index);
                String source = JSONObject.toJSONString(trade);
                indexRequest.source(source, XContentType.JSON);
                bulkRequest.add(indexRequest);
            }
            BulkResponse responses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println("同步到ES状态:" + !responses.hasFailures());
            pageNum++;
        }
    }


    /**
     * 批量添加文档
     */
    @Test
    public void batchAddOrderDoc() throws IOException {
        int pageNum = 1;
        int pageSize = 10000;
        while (true) {
            System.out.println("pageNum=" + pageNum + "|pageSize=" + pageSize);
            BulkRequest bulkRequest = new BulkRequest();
            PageHelper.startPage(pageNum, pageSize);
            List<Order> orderList = orderMapper.selectList(new QueryWrapper<Order>().eq("seller_id", 50007471));
            if (CollectionUtils.isEmpty(orderList)) {
                break;
            }
            for (Order trade : orderList) {
                IndexRequest indexRequest = new IndexRequest(index);
                String source = JSONObject.toJSONString(trade);
                indexRequest.source(source, XContentType.JSON);
                bulkRequest.add(indexRequest);
            }
            BulkResponse responses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println("同步到ES状态:" + !responses.hasFailures());
            pageNum++;
        }
    }


    /**
     * 批量添加文档
     */
    @Test
    public void batchAddShopBuyerDoc() throws IOException {
        int pageNum = 1;
        int pageSize = 10000;
        while (true) {
            System.out.println("pageNum=" + pageNum + "|pageSize=" + pageSize);
            BulkRequest bulkRequest = new BulkRequest();
            PageHelper.startPage(pageNum, pageSize);
            List<ShopBuyer> shopBuyerList = shopBuyerMapper.selectList(new QueryWrapper<ShopBuyer>().eq("seller_id", 50007471));
            if (CollectionUtils.isEmpty(shopBuyerList)) {
                break;
            }
            for (ShopBuyer trade : shopBuyerList) {
                IndexRequest indexRequest = new IndexRequest(index);
                String source = JSONObject.toJSONString(trade);
                indexRequest.source(source, XContentType.JSON);
                bulkRequest.add(indexRequest);
            }
            BulkResponse responses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println("同步到ES状态:" + !responses.hasFailures());
            pageNum++;
        }
    }


    /**
     * 搜索
     *
     * @throws IOException
     */
    @Test
    public void search() throws IOException {
        SearchRequest request = new SearchRequest(index);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder
                .must();
        builder.query(boolQueryBuilder).from(0).size(10000);
        request.source(builder);
        System.out.println("搜索语句为: " + request.source().toString());
        SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(search);
        SearchHits hits = search.getHits();
        SearchHit[] hitsArr = hits.getHits();
        for (SearchHit documentFields : hitsArr) {
            System.out.println(documentFields.getSourceAsString());
        }
        System.out.println(hitsArr.length);

    }


    @Test
    public void search2() {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        sourceBuilder.fetchSource(new String[]{"name", "age"}, new String[]{});
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("hobby", "唱歌");
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "逍遥");
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
        rangeQueryBuilder.gte(20);
        rangeQueryBuilder.lte(40);
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(matchQueryBuilder);
        boolBuilder.must(termQueryBuilder);
        boolBuilder.must(rangeQueryBuilder);
        sourceBuilder.query(boolBuilder);
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.source(sourceBuilder);
        try {
            System.out.println("搜索语句为: " + searchRequest.source().toString());
            SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println(search);
            SearchHits hits = search.getHits();
            SearchHit[] hitsArr = hits.getHits();
            for (SearchHit documentFields : hitsArr) {
                System.out.println(documentFields.getSourceAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文档
     *
     * @throws IOException
     */
    @Test
    public void deleteDoc() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index, "vk11WHUB2WFtIWtBQHqR");
        DeleteResponse response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 删除索引
     *
     * @throws IOException
     */
    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        AcknowledgedResponse response = restHighLevelClient.indices()
                .delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }


}
