package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.IPOdetail;
import com.example.demo.StockExchange;
import com.example.demo.service.IPOservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class IPOcontroller {
	
	@Autowired
	IPOservice service;
	
//	For updating a IPO
	@RequestMapping(method = RequestMethod.PUT, value = "/ipo/{id}")
	void updateUser(@RequestBody IPOdetail ipo,@PathVariable int id) {
		service.updateIPO(ipo,id);
	}
	//to get all details
		@RequestMapping("/ipo")
		Iterable<IPOdetail> getAlldata(){
			
			
			return service.getAllData();
		}
		
		
		@RequestMapping("/ipo/name/{name}")
		Optional<IPOdetail> getipoByName(@PathVariable String name){
			
			return service.getipoByName(name);
		}
		
		
		//For adding a new User
		@RequestMapping(method = RequestMethod.POST, value = "/ipo")
		void addipo(@RequestBody IPOdetail ipo) {
			service.addipo(ipo);
		}

//		
		
		//For deleting a User
		@RequestMapping(method = RequestMethod.DELETE, value = "/ipo/{name}")
		void deletestockexchange(@PathVariable String name) {
			service.deleteipo(name);
		}

	
	
}
