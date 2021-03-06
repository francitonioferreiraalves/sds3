package com.tito.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tito.dsvendas.dto.SaleSuccessDto;
import com.tito.dsvendas.dto.SaleSumDto;
import com.tito.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.tito.dsvendas.dto.SaleSumDto(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj Group BY obj.seller")
	List<SaleSumDto> amountGroupedBySeller();

	@Query("SELECT new com.tito.dsvendas.dto.SaleSuccessDto(obj.seller, SUM(obj.visited) , SUM(obj.deals)) "
			+ " FROM Sale AS obj Group BY obj.seller")
	List<SaleSuccessDto> successGroupedBySeller();

}
