package com.springboot.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.model.User;
import com.springboot.security.service.UserService;

@RestController
@RequestMapping("/public")
public class HomeController {

	

	@GetMapping("/home")
	public String home() {
		return "welcome to home page";

	}

	@GetMapping("/login")
	public String login() {
		return "welcome to login page";

	}
     
	@GetMapping("/register")
	public String register() {
		return "welcome to register page";
	}
}
