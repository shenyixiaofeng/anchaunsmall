package com.tedu.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/*
 * @Service作用：
 * 标识当前类属于service层
 * 表示当前类的对象的创建交给spring容器负责*/
@Service
public class DoorServiceImpl implements DoorService {
	/*当前接口的实例将由spring容器负责创建，并赋值给改变量*/
	@Autowired
	private DoorMapper dao;
    /*查询所有门店*/
	@Override
	public List<Door> findAll() {
		List<Door> list = dao.findAll();
		return list;
	}
	/*新增门店信息*/
	@Override
	public void addDoor(Door door) {
		//调用dao层新增门店信息的方法
		dao.addDoor(door);
		
	}
	/*根据id删除门店信息*/
	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}
	/*根据id查询门店详情信息*/
	@Override
	public Door findById(Integer id) {
		Door door=dao.findById(id);
		return door;
	}
	/*根据id修改门店信息*/
	@Override
	public void updateById(Door door) {
		dao.updateById(door);
		
	}

}
