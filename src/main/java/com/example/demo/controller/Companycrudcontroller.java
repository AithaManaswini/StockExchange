package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Company;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class Companycrudcontroller {
	
	private List<Company> employees;

	@GetMapping(produces = "application/json")
	public List<Company> firstPage() {
		return employees;
	}
	@PostMapping
	public Company create(@RequestBody Company comp) {
		employees.add(comp);
		return comp;
	}
	@DeleteMapping(path = { "/{name}" })
	public Company delete(@PathVariable("name")String name) {
		Company deletedEmp = null;
		for (Company emp : employees) {
			if (emp.getName().equals(name)) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}
	@GetMapping(path= {"/{name}"})
	public List<Company> findbyname(@PathVariable("name")String name){
		
		List<Company> cl=null;
	for (Company emp : employees) {
		if (emp.getName().contains(name)) {
			cl.add(emp);
			
			
		}
	}
	return cl;
}
	

}
