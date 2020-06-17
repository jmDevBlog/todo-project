package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Article;

@Mapper
public interface ArticleDao {
	public List<Article> getList();
	
	public int create(String title);

	public int getTotalCount();

	public void delete(int id);

	public void done(int id);

	public void modify(Article article);
	
	public Article read(int id);

}
