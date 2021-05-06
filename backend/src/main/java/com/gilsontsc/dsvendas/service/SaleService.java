package com.gilsontsc.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gilsontsc.dsvendas.dto.SaleDTO;
import com.gilsontsc.dsvendas.entities.Sale;
import com.gilsontsc.dsvendas.repositories.SaleRepository;
import com.gilsontsc.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerrepository;
	
	@Transactional(readOnly = true)// O true é para não fazer loc no banco.
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerrepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		
		return result.map(x -> new SaleDTO(x));
	}
}