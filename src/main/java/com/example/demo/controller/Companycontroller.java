package com.example.demo.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Company;

import com.example.demo.service.Companyservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Companycontroller {

	
	@Autowired
	Companyservice service;
	
	//to get all details
	@RequestMapping("/companies")
	Iterable<Company> getAlldata(){
//	void getAlldata() {
		
//		System.out.println("hello");
		return service.getAllData();
	}
//	@GetMapping(produces = "application/json")
//	@RequestMapping({ "/validateLogin" })
//	public Usermessage validateLogin() {
//		return new Usermessage("User successfully authenticated");
//	}
//	
	@RequestMapping(value="/companies/name/{name}")
	Optional<Company> getCompanyByName(@PathVariable String name){
		
		return service.getCompanyByName(name);
	}
//	@RequestMapping(value="/companies/id/{id}",method = RequestMethod.GET)
//	Optional<Company> getCompanyById(@PathVariable Long id){
//		
//		return service.getCompanyById(id);
//	}
	@RequestMapping(value="/companies/{name}",method = RequestMethod.GET)
	List<Company> getCompanyByKeyName(@PathVariable String name){
		
		return service.getCompanyByKeyName(name);
//		return "helleo";
	}
	
	
	//For adding a new User
	@RequestMapping(method = RequestMethod.POST, value = "/companies")
	void addCompany(@RequestBody Company company) {
		service.addCompany(company);
	}

//	For updating a User
	@RequestMapping(method = RequestMethod.PUT, value = "/companies/{id}")
	void updateUser(@RequestBody Company company,@PathVariable Long id) {
		service.updateCompany(company, id);
	}

	//For deleting a User
	@RequestMapping(method = RequestMethod.DELETE, value = "/companies/{name}")
	void deleteUser(@PathVariable String name) {
		service.deleteCompany(name);
	}
	
}


