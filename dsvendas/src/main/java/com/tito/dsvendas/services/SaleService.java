package com.tito.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tito.dsvendas.dto.SaleDto;
import com.tito.dsvendas.entities.Sale;
import com.tito.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {

	private SaleRepository repository;

	public List<SaleDto> findAll() {
		List<Sale> result = repository.findAll();
		return result.stream().map(x -> new SaleDto(x)).collect(Collectors.toList());

	}

}
