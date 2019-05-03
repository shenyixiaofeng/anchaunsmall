package com.tedu.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

public class testmybatis {
	public static void main(String[] args) throws Exception {
		//读取mybatis-config.xml文件
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		//获取SqlSessionFactory工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//获取session对象
		SqlSession session = factory.openSession();
		//获取Mapper接口实现类的实例
		DoorMapper mapper = session.getMapper(DoorMapper.class);
		//执行查询sql，并输出结果
		List<Door> list = mapper.findAll();
		for(Door door:list) {
			System.out.println(door);
		}
	}
}
	   

