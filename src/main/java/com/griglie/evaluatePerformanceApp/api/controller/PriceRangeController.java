package com.griglie.evaluatePerformanceApp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griglie.evaluatePerformanceApp.api.services.PriceRangeService;
import com.griglie.evaluatePerformanceApp.persistence.entities.PriceRange;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/priceRange")
public class PriceRangeController {
	
	@Autowired
    private PriceRangeService priceRangeService;
    
    @GetMapping(value="/getAll")
    public List<PriceRange> getAllPriceRange() {
    	return priceRangeService.getAllPriceRange();
    }
    
}
