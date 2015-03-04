package com.czmen.wechat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 测试Index主页。
 * 
 * @author YANGYONG
 *
 */
@Controller("testIndexController")
public class TestIndexController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getTest(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}
}
