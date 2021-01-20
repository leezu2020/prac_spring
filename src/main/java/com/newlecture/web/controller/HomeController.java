package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("index")
	public String index() {
		//view ���� ����
		//return "Hello Index";
		// root.index�� tiles���� resolving�� ����
		return "root.index";
	}
	
	
	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception { // TODO Auto-generated
	 * method stub
	 * 
	 * ModelAndView mv = new ModelAndView("root.index"); mv.addObject("data",
	 * "Hello Spring MVC~"); //mv.setViewName("/WEB-INF/view/index.jsp"); return mv;
	 * }
	 */
	
}
