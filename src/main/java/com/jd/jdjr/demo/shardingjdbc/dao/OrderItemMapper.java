package com.jd.jdjr.demo.shardingjdbc.dao;

import com.jd.jdjr.demo.shardingjdbc.po.OrderItem;

import java.util.List;
import java.util.Map;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> selectByParams(Map<String, Object> map);
}