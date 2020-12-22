package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.User;
import com.example.demo.repo.Userrepository;

@Service
public class Userservice {
	
	@Autowired
	Userrepository repo;
	
	public Iterable<User> getAllData() {
		return repo.findAll();
	}
	
	public Optional<User> getUserByName(String name){
		
		return repo.findByName(name);
	}
	
	
	public void addUser(User user) {
		
		repo.save(user);
	}
	
	public void deleteUser(String name) {
		repo.deleteByName(name);
	}
	
	public void updateUser(User user,Integer id) {
		
		repo.deleteById(id);
		repo.save(user);
	}
	
}

