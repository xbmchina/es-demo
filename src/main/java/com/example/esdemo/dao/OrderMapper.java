package com.example.esdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.esdemo.entity.Order;
import com.example.esdemo.entity.Trade;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
