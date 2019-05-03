package com.tedu.service;

import java.util.List;

import com.tedu.pojo.Order;

public interface OrderService {
	//查询所有订单信息
	public List<Order> findAll();
	//新增订单信息
	public void addOrder(Order order);
	//删除订单
	public void orderDelete(Integer id);
	//按照id查询信息
	public Order findById(Integer id);
	//修改信息
	public void orderUpdate(Order order);

}
