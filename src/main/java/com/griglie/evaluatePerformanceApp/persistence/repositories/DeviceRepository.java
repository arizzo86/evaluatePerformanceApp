package com.griglie.evaluatePerformanceApp.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.griglie.evaluatePerformanceApp.persistence.entities.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

	Device findAllByDescriptionAndOperatingSystem(String description, String operatingSystem);
	
	boolean existsByDescriptionAndOperatingSystem(String description, String operatingSystem);

	@Transactional
	@Modifying
	@Query("UPDATE Device "
			+ "SET idPriceRange = :idPriceRange, "
			+ "lastModifiedDate = current_timestamp "
			+ "WHERE description = :description "
			+ "AND operatingSystem = :operatingSystem")
	void update( @Param("description") String description, @Param("operatingSystem") String operatingSystem, @Param("idPriceRange") Long idPriceRange);
  

}
