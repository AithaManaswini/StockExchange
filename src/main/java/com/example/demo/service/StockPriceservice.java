package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Company;
import com.example.demo.StockPrice;
import com.example.demo.repo.CompanyRepository;
import com.example.demo.repo.StockPriceRepository;

@Service
public class StockPriceservice {
	@Autowired
	StockPriceRepository repo;
	
	public Iterable<StockPrice> getAllData() {
		return repo.findAll();
	}
	
	public List<StockPrice> getstockpriceByName(String name){
		
		return repo.findByName(name);
	}
	
	public Optional<StockPrice> getstockpriceById(Long Id){
		
		return repo.findById(Id);
	}
	
	
	
	public void addstockprice(StockPrice stockprice) {
		
		repo.save(stockprice);
	}
	
	public void deletestockprice(String name) {
		repo.deleteByName(name);
	}
	
	
}
