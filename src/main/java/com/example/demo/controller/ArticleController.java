package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Article;
import com.example.demo.model.User;
import com.example.demo.service.ArticleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ArticleController {
	// localhost:8085/list

	private final ArticleService articleService;

	@GetMapping("/list")
	public String showList(Model model) {

		List<Article> articleList = articleService.getList();

		model.addAttribute("articleList", articleList);

		return "/list";
	}

	@GetMapping("/create")
	public String showCreate() {
		return "/create";
	}

	
	
	@PostMapping("/docreate")
	@ResponseBody 
	public String doCreate(Article article, User user) {
		
		articleService.create(article, user);
		String msg = "할 일이 추가 되었습니다.";
		
		return message(msg); 
	  
	}
		  
	@GetMapping("/doDelete")
	@ResponseBody 
	public String doDelete(long id) {
		System.out.println("id = " +id);
		articleService.delete(id); 
		
		String msg = id + "번 할 일이 삭제 되었습니다.";
		return message(msg);
		
	}
	  
	  
		
	@GetMapping("/done")  
	@ResponseBody public String doDone(long id) { 
		articleService.done(id); 
		String msg = id + "번 할일 완료";
		
		return message(msg); 
		
	}
	  
	@GetMapping("/modify") 
	public String showModify() { 
		return "/modify"; 
		
	}  
	@PostMapping("/domodify")  
	@ResponseBody 
	public String doModify(long id, String title, Model model) { 
		articleService.modify(id, title); 
		String msg = "주제가 변경 되었습니다.";
		
		return message(msg); 
		
	}
	

	private String message(String msg) {

		StringBuilder sb = new StringBuilder();

		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./list');");

		sb.insert(0, "<script>");
		sb.append("</script>");

		return sb.toString();

	}

}
