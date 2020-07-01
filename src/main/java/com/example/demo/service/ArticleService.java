
package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.Article;
import com.example.demo.model.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {

	  private final ArticleRepository articleRepository;
  
	  public List<Article> getList() { 
		  List<Article> list = articleRepository.findAll(); 
		  return list; 
		  
	  }
	  
	  public Article create(Article article, User user) {
		  
		  article.setUser(user);
		  article = articleRepository.save(article);  

		  return article; 
		  
	  }
	  public void delete(long id) { 
		  articleRepository.deleteById(id);
		  
	  }
	 
	
	  public void done(long id) { 
		  Article article = articleRepository.getOne(id);
		  article.setDone(true); 
		  article.setDdate(LocalDateTime.now());
		  articleRepository.save(article); 
		  
	  } 
	  public void modify(long id, String title) { 
		  Article article = articleRepository.getOne(id); 
		  article.setTitle(title);
		  articleRepository.save(article); 
		  
	  }
	 
}
