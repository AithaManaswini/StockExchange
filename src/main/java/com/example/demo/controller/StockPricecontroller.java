package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Company;
import com.example.demo.StockPrice;
import com.example.demo.service.Companyservice;
import com.example.demo.service.StockPriceservice;
@CrossOrigin(origins="http://localhost:4200")
@Controller
public class StockPricecontroller {

	
	@Autowired
	StockPriceservice service;
	
	//to get all details
	@RequestMapping(method = RequestMethod.GET,value="/stockprice")
	@ResponseBody
	Iterable<StockPrice> getAlldata(){
//	void getAlldata() {
		
//		System.out.println("hello");
		return service.getAllData();
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="/stockprice/{name}")
	@ResponseBody
	List<StockPrice> getstockpriceByName(@PathVariable String name){
		
		return service.getstockpriceByName(name);
	}
//	@RequestMapping(value="/companies/id/{id}",method = RequestMethod.GET)
//	Optional<Company> getCompanyById(@PathVariable Long id){
//		
//		return service.getCompanyById(id);
//	}
	
	
	//For adding a new User
	@RequestMapping(method = RequestMethod.POST, value = "/stockprice")
	void addCompany(@RequestBody StockPrice se) {
		service.addstockprice(se);
	}

//	

	//For deleting a User
	@RequestMapping(method = RequestMethod.DELETE, value = "/stockprice/{name}")
	void deletestockprice(@PathVariable String name) {
		service.deletestockprice(name);
	}
	
}
