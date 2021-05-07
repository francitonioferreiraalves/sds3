package com.tito.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tito.dsvendas.dto.SaleDto;
import com.tito.dsvendas.dto.SaleSuccessDto;
import com.tito.dsvendas.dto.SaleSumDto;
import com.tito.dsvendas.entities.Sale;
import com.tito.dsvendas.repositories.SaleRepository;
import com.tito.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sallerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDto> findAll(Pageable pageable) {
		sallerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDto(x));

	}

	@Transactional(readOnly = true)
	public List<SaleSumDto> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}

	@Transactional(readOnly = true)
	public List<SaleSuccessDto> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}

}
