package com.tedu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Door;
import com.tedu.pojo.Order;
import com.tedu.service.DoorService;
import com.tedu.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private DoorService doorService;
	@Autowired
	private OrderService orderService;
	/**查询所有订单信息*/
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		//1.查询所有门店信息(List<Door>)
		List<Door> doorList = doorService.findAll();
		//2.将门店集合存入model，带到jsp
		model.addAttribute("doorList",doorList);
		//3.查询所有订单信息(List<Order>)
		List<Order> orderList = orderService.findAll();
		//4.将订单集合存入model，带到jsp
		model.addAttribute("orderList", orderList);
		System.out.println(doorList);
		System.out.println(orderList);
		//转向订单列表页面
		return "order_list";
	}
	/**查询所有门店并跳转到订单新增页面*/
  @RequestMapping("/toAddOrder")
  public String toAddOrder(Model model) {
	  //1.查询所有门店信息
	  List<Door> doorList = doorService.findAll();
	  //2.带到订单新增页面，取出并显示
	  model.addAttribute("doorList", doorList);
	  return "order_add";
  }
  /**新增订单*/
  @RequestMapping("/orderAdd")
  public String orderAdd(Order order) {
	  order.setOrderTime(new Date());
	  order.setPayTime(new Date());
	  //调用service层的方法添加新增订单
	  System.out.println(order);
	  orderService.addOrder(order);
	  //重定向到查询所有订单的方法
	  return "redirect:/orderList";
  }
  /**根据id删除订单信息*/
  @RequestMapping("/orderDelete")
  public String orderDelete(Integer id) {
	  orderService.orderDelete(id);
	  return "redirect:/orderList";
  }
  /**根据id查询订单信息，将查询到的订单信息带到修改页面进行数据的回写
   * */
  @RequestMapping("/orderInfo")
  public String orderInfo(Integer id,Model model) {
	  //查询所有门店的集合,将所有门店集合存到model中
	  List<Door> list = doorService.findAll();
		//4.将所有门店列表存入Model中
		model.addAttribute("list", list);
	  Order order=orderService.findById(id);
	  model.addAttribute("order", order);
	  return "order_update";
  }
  /**根据id修改订单信息
   * */
  @RequestMapping("/orderUpdate")
  public String orderUpdate(Order order) {
	  orderService.orderUpdate(order);
	  return "redirect:/orderList";
  }
}
