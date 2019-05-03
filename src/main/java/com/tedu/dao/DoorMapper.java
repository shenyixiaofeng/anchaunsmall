package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

public interface DoorMapper {
	/*查询所有门店的方法*/
	public List<Door> findAll();
    /*添加门店信息*/
	public void addDoor(Door door);
	/*根据id删除门店信息*/
	public void deleteById(Integer id);
	/*根据id查询门店详情信息*/
	public Door findById(Integer id);
	/*根据id修改门店信息*/
	public void updateById(Door door);

}
