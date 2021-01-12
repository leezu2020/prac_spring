package com.newlecture.web.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("apiNoticeController")
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@RequestMapping("list")
	public String list() {
		
		
		// 글자를 반환
		return "공지사항 list";
	}
}
