package com.tito.dsvendas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.tito.dsvendas.entities.Sale;

public class SaleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	private SellerDto saller;
	
	

	public SaleDto() {

	}

	public SaleDto(Sale sale) {

		id = sale.getId();
		visited = sale.getVisited();
		deals = sale.getDeals();
		amount = sale.getAmount();
		date = sale.getDate();
		saller = new SellerDto(sale.getSeller());
	}
		
	public SaleDto(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDto saller) {
	
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.saller = saller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SellerDto getSaller() {
		return saller;
	}

	public void setSaller(SellerDto saller) {
		this.saller = saller;
	}

}
