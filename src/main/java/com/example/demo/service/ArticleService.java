package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dto.Article;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	
	public List<Article> getList(){
		return articleDao.getList();
	}
	public int create(String title){
		int cnt = articleDao.create(title);
		return cnt;
	}
	public int getTotalCount() {
		return articleDao.getTotalCount();
		
	}
	public void delete(int id) {
		articleDao.delete(id);
		
	}
	

}
