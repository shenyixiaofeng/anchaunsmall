package com.tedu.service;

import java.util.List;


import com.tedu.pojo.Door;

public interface DoorService {
	/*查询所有门店的方法*/
	public List<Door> findAll();
    /*新增门店信息*/
	public void addDoor(Door door);
	/*删除门店信息*/
	public void deleteById(Integer id);
	/*根据id查询门店信息*/
	public Door findById(Integer id);
	/*根据id修改门店信息*/
	public void updateById(Door door);
	

}
