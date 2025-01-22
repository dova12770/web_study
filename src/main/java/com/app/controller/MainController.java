package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.user.User;
import com.app.service.user.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;

	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/main";
	}
	
	@GetMapping("/joinMembership")
	public String join() {
		return "user/joinMemberShip";
	}
	@PostMapping("/joinMembership")
	public String joinAction(User user) {
		int result = userService.addUser(user);
		return "user/joinMemberShip";
	}
	
}
