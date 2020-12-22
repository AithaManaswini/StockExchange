package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockexchangetable")
public class StockExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="Stockexchange")
	private String stockexchange;
	
	
	@Column(name="brief")
	private String brief;
	
	@Column(name="contact")
	private String contact;
	
	
	@Column(name="remarks")
	private String remarks;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStockexchange() {
		return stockexchange;
	}


	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}


	public String getBrief() {
		return brief;
	}


	public void setBrief(String brief) {
		this.brief = brief;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

	
}
