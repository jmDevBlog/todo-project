package com.example.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	@Transactional
	public void userjoin(User user) {
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true) // select 할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료
	public User login(User user) {
		return userRepository.login(user.getUsername(), user.getPassword());
	}

}
