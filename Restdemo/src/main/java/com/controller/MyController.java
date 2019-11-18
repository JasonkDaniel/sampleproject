package com.controller;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;

@RestController
public class MyController {

	@RequestMapping(value="/one",method=RequestMethod.GET)
	public String sayHello()
	{
		System.out.println("I am in say hello( ) "); // log 4j
		// logic 
		return "God bless";
	}
	
	@RequestMapping(value="/two",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public User getUser()
	{
		System.out.println("I am in say hello( ) "); // log 4j
		// logic 
		return new User(1234L, "lunch", "break");
	}
	@GetMapping(value="/three")
	public User getUserById(@RequestParam ("alais") long userId)
	{
		User user = null;
		if (userId > 0)
		{	//DAO 
			if(userId == 1234L)
			{
			user = new User(1234L, "lunch", "break");	
			}
			if(userId == 5678L)
			{
			user = new User(5678L, "Sleep", "well");	
			}
		}
		return user;
		
	}
	@PostMapping(value="/four")
	public User createUser(@RequestBody User user)
	{
		System.out.println("from ui userid " + user.getUserId());
		System.out.println("from ui name   " + user.getUserName());
		user.setUserName("welcome :" + user.getUserName());
		return user;
	}
}
