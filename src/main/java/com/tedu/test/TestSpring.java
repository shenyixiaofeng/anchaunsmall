package com.tedu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.pojo.Door;

/*测试spring的运行环境*/
public class TestSpring {

	public static void main(String[] args) {
		//读取spring的配置文件
		ApplicationContext appCon=
				new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Door door = (Door)appCon.getBean("door");
		System.out.println(door);
	}

}
