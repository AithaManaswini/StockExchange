package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.Company;
@CrossOrigin(origins="http://localhost:4200")
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{
	
	@Query(value="select * from company where name= :name ",nativeQuery=true)
	Optional<Company> findByName(@Param("name")String name);
//	
	@Modifying
	@Transactional
	@Query(value="delete  from company where name= :name ",nativeQuery=true)
	void deleteByName(@Param("name")String name);
//	@Query(value="select *  from company where name LIKE %:name% ",nativeQuery=true)
	List<Company> findBynameContaining(String name);
}