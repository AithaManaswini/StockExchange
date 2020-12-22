package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IPOdetail;
import com.example.demo.StockExchange;
import com.example.demo.repo.IPOrepository;

@Service
public class IPOservice {
	@Autowired
	IPOrepository repo;
	
	public void updateIPO(IPOdetail IPO,Integer id) {
			
			
			
			repo.deleteById(id);
			repo.save(IPO);
		}
	public Iterable<IPOdetail> getAllData() {
		return repo.findAll();
	}
	
	public Optional<IPOdetail> getipoByName(String name){
		
		return repo.findByName(name);
	}
	
	
	public void addipo(IPOdetail ipo) {
		
		repo.save(ipo);
	}
	
	public void deleteipo(String name) {
		repo.deleteByName(name);
	}
	
	
}