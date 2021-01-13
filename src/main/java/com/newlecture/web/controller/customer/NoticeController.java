package com.newlecture.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller	// 객체화하기위해 필요
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/customer/notice/list")
	public String list(@RequestParam(name = "p", defaultValue = "1") String page) throws ClassNotFoundException, SQLException {
		//String p = request.getParameter("p");
		System.out.println("page:" + page);
		
		//List<Notice> list = noticeService.getList(1, "TITLE", "");
		
		return "notice.list";
	}
	
	@RequestMapping("/customer/notice/detail")
	public String detail() {
		return "notice.detail";
	}
}
