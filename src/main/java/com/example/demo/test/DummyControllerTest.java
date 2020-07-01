package com.example.demo.test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class DummyControllerTest {
	
	//http://localhost:8085/dummy/join
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username : "+ user.getId());
		System.out.println("password : "+ user.getPassword());
		System.out.println("email : "+ user.getEmail());
		return "회원가입 완료";
	}

}
