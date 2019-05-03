package com.tedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Order;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper dao;
	/**查询所有订单信息*/
	@Override
	public List<Order> findAll() {
		List<Order> list=dao.findAll();
		return list;
	}
	@Override
	public void addOrder(Order order) {
		dao.addOrder(order);
		
	}
	@Override
	public void orderDelete(Integer id) {
		dao.orderDelete(id);
		
	}
	@Override
	public Order findById(Integer id) {
		Order order=dao.findById(id);
		return order;
	}
	@Override
	public void orderUpdate(Order order) {
		dao.orderUpdate(order);
		
	}

}
