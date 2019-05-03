package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Order;

public interface OrderMapper {

	List<Order> findAll();

	void addOrder(Order order);

	void orderDelete(Integer id);

	Order findById(Integer id);

	void orderUpdate(Order order);

}
