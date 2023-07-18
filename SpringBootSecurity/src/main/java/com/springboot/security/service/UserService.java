package com.springboot.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.security.model.User;

@Service
public class UserService {

	List<User> list= new ArrayList();
	
	 public UserService() {
	 
		 list.add(new User("pritam","123","pritam@gmail.com"));
		 list.add(new User("xyz","123","xyz@gmail.com"));
		 list.add(new User("abc","123","abc@gmail.com"));
	 }
	
	  public List<User> getAllUsers(){
		  return this.list;
	  }
	  
	  public User getUser(String username) {
		  
		   return this.list.stream().filter((user)->user.getUsername().equals(username))
				   .findAny().orElse(null);
	  }
	  
	  public User addUser(User user) {
		  this.list.add(user);
		  return user;
	  }
}
