package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*测试springmvc的运行环境*/
@Controller
public class testspringmvc {
	@RequestMapping("/testSpringmvc")
	public String testSpringmvc() {
		System.out.println("testSpringmvc.....");
		return "test";
	}
}
