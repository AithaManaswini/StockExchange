package com.example.demo.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.User;
@CrossOrigin(origins="http://localhost:4200")
@Repository
public interface Userrepository extends CrudRepository<User,Integer>{
	
	@Query(value="select * from user where username= :name ",nativeQuery=true)
	Optional<User> findByName(@Param("name")String name);
	
	@Modifying
	@Transactional
	@Query(value="delete  from user where username= :name ",nativeQuery=true)
	void deleteByName(@Param("name")String name);

}
