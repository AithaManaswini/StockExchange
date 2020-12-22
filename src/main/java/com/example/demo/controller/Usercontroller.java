package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.service.Userservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Usercontroller {

	
	@Autowired
	Userservice service;
	
	//to get all details
	@RequestMapping("/users")
	Iterable<User> getAlldata(){
		
		
		return service.getAllData();
	}
	
	
	@RequestMapping("/users/{name}")
	Optional<User> getCompanyByName(@PathVariable String name){
		
		return service.getUserByName(name);
	}
	
	
	//For adding a new User
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	void addUser(@RequestBody User user) {
		service.addUser(user);
	}

//	For updating a User
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	void updateUser(@RequestBody User user,@PathVariable int id) {
		service.updateUser(user, id);
	}

	//For deleting a User
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{name}")
	void deleteUser(@PathVariable String name) {
		service.deleteUser(name);
	}
	
}



