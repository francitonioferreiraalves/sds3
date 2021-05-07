package com.tito.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tito.dsvendas.dto.SaleDto;
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

}
