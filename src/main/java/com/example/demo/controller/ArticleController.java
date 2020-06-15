package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;

import groovy.util.logging.Slf4j;
import jline.internal.Log;

@Controller
@Slf4j
public class ArticleController {
	// localhost:8085/article/list
	@Autowired
	private ArticleService articleService;
	// get post 명시 
	@RequestMapping("/article/list")
	public String showList(Model model) {
		List<Article> articleList = articleService.getList();
		int totalCount = articleService.getTotalCount();
		Log.info("articlelist : " + articleList);
		
		model.addAttribute("articleList", articleList);
		model.addAttribute("totalCount", totalCount);
		
		return "article/list";
	}
	
	@RequestMapping("/article/create")
	public String showCreate() {

		return "article/create";
	}
	
	@RequestMapping("/article/docreate")
	@ResponseBody
	public String doCreate(@RequestParam String title) {
		articleService.create(title);
		
		String msg = "할 일이 추가 되었습니다.";
				
		StringBuilder sb = new StringBuilder();

		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./list');");

		sb.insert(0, "<script>");
		sb.append("</script>");

		return sb.toString();
	} 
	
	@RequestMapping("/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		articleService.delete(id);
		
		String msg = id + "번 할 일이 삭제 되었습니다.";
				
		StringBuilder sb = new StringBuilder();

		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./list');");

		sb.insert(0, "<script>");
		sb.append("</script>");

		return sb.toString();
	}

}
