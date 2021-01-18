package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {	// <bean name="adminNoticeController" class="com.newlecture.web.controller.admin.board.NoticeController">

	@Autowired
	private ServletContext ctx;
	
	@RequestMapping("list")
	public String list() {
		
		return "admin.board.notice.list";
	}
	
	@GetMapping("reg")
	public String reg() {
	
		return "admin.board.notice.reg";
	}
	
	@PostMapping("reg")
	public String reg(String title, String content, MultipartFile[] files, String category, String[] foods, String food, HttpServletRequest request) throws IllegalStateException, IOException {
				
		
		for(MultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			long size = file.getSize();
			System.out.printf("fileName : %s, fileSize : %d\n", fileName, size);
			
			//ServletContext ctx = request.getServletContext();
			String webPath = "/static/upload";
			String realPath = ctx.getRealPath(webPath);
			System.out.printf("realPath : %s\n", realPath);
			File savePath = new File(realPath);	// 파일명이 포함되지 않은 경로
			// 업로드하기 위한 경로가 없을 경우 만들기
			if(!savePath.exists())	// 존재하는지 아닌지 boolean 반환
				savePath.mkdirs();
				
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);	// 파일명이 포함된 경로
			file.transferTo(saveFile);
		}
		
		System.out.println(category);
		for(String f : foods)
			System.out.println(f);
		
		return "admin.board.notice.reg";
		//return String.format("title:%s<br>content:%s<br>category:%s<br>food:%s", title, content, category, food);
	}
	
	@RequestMapping("edit")
	public String edit() {
		
		return "admin.board.notice.edit";
	}
	
	@RequestMapping("del")
	public String del() {
		
		return "";
	}
}
