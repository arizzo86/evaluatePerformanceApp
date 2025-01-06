package com.griglie.evaluatePerformanceApp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.griglie.evaluatePerformanceApp.persistence.entities.PriceRange;
import com.griglie.evaluatePerformanceApp.persistence.repositories.PriceRangeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class PriceRangeService {
	
	@Autowired
    private PriceRangeRepository priceRangeRepository;  


    public List<PriceRange> getAllPriceRange() {
        return priceRangeRepository.findAll();
    }
    
  
}
