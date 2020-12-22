package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.Company;
import com.example.demo.StockPrice;


@CrossOrigin(origins="http://localhost:4200")
@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice,Long>{
	

	@Query(value="select * from stockprice where companycode= :name ",nativeQuery=true)
	List<StockPrice> findByName(@Param("name")String name);
//	
	@Modifying
	@Transactional
	@Query(value="delete  from stockprice where companycode= :name ",nativeQuery=true)
	void deleteByName(@Param("name")String name);
}
