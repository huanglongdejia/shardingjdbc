package com.jd.jdjr.demo.test;

import com.alibaba.fastjson.JSON;
import com.jd.jdjr.demo.shardingjdbc.dao.OrderItemMapper;
import com.jd.jdjr.demo.shardingjdbc.dao.OrderMapper;
import com.jd.jdjr.demo.shardingjdbc.po.Order;
import com.jd.jdjr.demo.shardingjdbc.po.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-config-sharding.xml"})
public class TestSharding {


    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Test
    public void testAdd() {
//        List<Long> orderIds = new ArrayList<>(10);
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            order.setOrderId(i + 0L);
            order.setUserId(51);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
            long orderId = order.getOrderId();
//            orderIds.add(orderId);

            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(51);
            orderItemMapper.insert(item);
        }
    }

    @Test
    public void testQuery() {
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", 1L);

        List<Order> orders = orderMapper.selectByParams(map);
        System.out.println(JSON.toJSONString(orders));

        List<OrderItem> items = orderItemMapper.selectByParams(map);

        System.out.println(JSON.toJSONString(items));

    }

    @Test
    public void testUpdate() {
        Order order = new Order();
        order.setOrderId(1L);
        order.setStatus("23424");
        final int i = orderMapper.updateByPrimaryKeySelective(order);

        OrderItem item = new OrderItem();
        item.setOrderId(1L);
        item.setUserId(23424);
        orderItemMapper.updateByPrimaryKeySelective(item);
    }


}
