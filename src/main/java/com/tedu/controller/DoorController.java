package com.tedu.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Door;
import com.tedu.service.DoorService;

@Controller
public class DoorController {
	@Autowired
	private DoorService service;
	/*1.查询所有门店管理模块*/
	@RequestMapping("/doorList")
	public String doorList(Model model) {
		List<Door> list = service.findAll();
		model.addAttribute("list", list);
		return "door_list";
	}
	/*2.新增门店信息*/
	@RequestMapping("/doorAdd")
	public String doorAdd(Door door) {
		//1.调用service层的新增门店方法
		service.addDoor(door);
		
		/*三种方法：
		 * (1)调用doorAdd方法,主页方法上需要填写model参数
		 * (2)请求转发
		 * (3)重定向
		 * */
        return "forward:/doorList";
	}
	/*根据id删除门店信息*/
	@RequestMapping("/doorDelete")
	public String doorDelete(Integer id) {
		//调用service方法根据id删除门店
		service.deleteById(id);
		return "forward:/doorList"; 
	}
	/*根据id修改门店信息*/
	@RequestMapping("/doorInfo")
	public String doorInfo(Integer id,Model model) {
		//调用service层根据id查询门店详情的方法
		Door door=service.findById(id);
		//将门店数据存入model中
		model.addAttribute("door", door);
		return "door_update";
	}
	/*根据id修改门店信息*/
	@RequestMapping("/doorUpdate")
	public String doorUpdate(Door door) {
		service.updateById(door);
		return "forward:/doorList";
	}





	/*{page}可以接收用户访问路径为/index、/_top
	 * 则page的值就是index、/_top
	 * /WEB-INF/pages/xx.jsp
	 * */
	@RequestMapping("/{page}")
	public String page(@PathVariable String page) {
		/*@PathVariable String page方法上的参数*/
		return  page;
	}
}
