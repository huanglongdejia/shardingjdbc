package com.jd.jdjr.demo.shardingjdbc.dao;

import com.jd.jdjr.demo.shardingjdbc.po.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByParams(Map<String, Object> map);
}