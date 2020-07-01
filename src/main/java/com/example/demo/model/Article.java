package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.ColumnDefault;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @lombok.ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 30)
	private String title;
	
	@Column(nullable = false)
	@ColumnDefault("false")
	private boolean done;
	
	@ManyToOne(fetch = FetchType.EAGER) // 한명의 유저는 여러개의 글 쌉가능
	@JoinColumn(name="userId")
	private User user;
	
	@Column(nullable = false)
	private LocalDateTime sdate;
	
	@Column(nullable = true)
	private LocalDateTime ddate;
	
	@PrePersist
	public void createdAt() {
		this.sdate = LocalDateTime.now();
	}
}
