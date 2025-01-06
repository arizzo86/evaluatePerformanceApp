package com.griglie.evaluatePerformanceApp.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.griglie.evaluatePerformanceApp.persistence.entities.PriceRange;

@Repository
public interface PriceRangeRepository extends JpaRepository<PriceRange, Long> {
  

}
