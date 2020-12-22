package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Company;
import com.example.demo.repo.CompanyRepository;

@Service
public class Companyservice {
	
	@Autowired
	CompanyRepository repo;
	
	public Iterable<Company> getAllData() {
		return repo.findAll();
	}
	
	public Optional<Company> getCompanyByName(String name){
		
		return repo.findByName(name);
	}
	
	public Optional<Company> getCompanyById(Long Id){
		
		return repo.findById(Id);
	}
	public List<Company> getCompanyByKeyName(String name){
		
		return repo.findBynameContaining(name);
	}
	
	
	public void addCompany(Company company) {
		
		repo.save(company);
	}
	
	public void deleteCompany(String name) {
		repo.deleteByName(name);
	}
	
	public void updateCompany(Company company,Long id) {
		
		repo.deleteById(id);
		repo.save(company);
	}
	
}
