package com.griglie.evaluatePerformanceApp.persistence.repositories;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.griglie.evaluatePerformanceApp.persistence.entities.DevicePerformance;
import com.griglie.evaluatePerformanceApp.persistence.entities.DevicePerformancePK;
import com.griglie.evaluatePerformanceApp.persistence.projections.DeviceProjection;

@Repository
public interface DevicePerformanceRepository extends JpaRepository<DevicePerformance, DevicePerformancePK> {
  
/***
 * a partire da description, sistema operativo e kpi mostrare la posizione in classifica
 */
	
	
	@Query("SELECT A.RowNr "
			+ "FROM ("
				+ "SELECT ROW_NUMBER() OVER (ORDER BY dp.result) AS RowNr, dev.description AS deviceDescription "
				+ "FROM DevicePerformance dp "
				+ "JOIN dp.key.performanceType pt on pt.id = :performanceType "
				+ "JOIN dp.key.device dev on dev.operatingSystem = :operatingSystem "
				+ ") A "
			+ "WHERE A.deviceDescription = :description ")
	Long getKpiPositionByDescriptionAndOperatingSystem (@Param("description") String description, @Param("operatingSystem") String operatingSystem, @Param("performanceType") Long performanceType);
	
/***
 * a partire da fascia di prezzo, sistema operativo e kpi mostrare i primi 10 in classifica	
*/
	@Query( "SELECT new com.griglie.evaluatePerformanceApp.persistence.projections.DeviceProjection("
			+ " ROW_NUMBER() OVER (ORDER BY dp.result) AS devicePosition, "
			+ "dp.result  AS resultValue, "
			+ "pt.id AS idPerformanceType, "
			+ "dev.description AS deviceDescription, "
			+ "dev.operatingSystem AS deviceOperatingSystem, "
			+ "dev.idPriceRange AS idPriceRange) "
			+ "FROM DevicePerformance dp "			
			+ "JOIN dp.key.performanceType pt on pt.id = :performanceType "
			+ "JOIN dp.key.device dev on dev.operatingSystem = :operatingSystem AND dev.idPriceRange = :idPriceRange "
			)
	List<DeviceProjection> getKpiTopTenByOperatingSystemAndPriceRange( @Param("operatingSystem") String operatingSystem, @Param("idPriceRange") Long idPriceRange, @Param("performanceType") Long performanceType, Pageable pageable);
	 
	
/***
 * a partire da fascia di prezzo e kpi mostrare i primi 10 in classifica
 */	

	@Query( "SELECT new com.griglie.evaluatePerformanceApp.persistence.projections.DeviceProjection("
			+ " ROW_NUMBER() OVER (ORDER BY dp.result) AS devicePosition, "
			+ "dp.result  AS resultValue, "
			+ "pt.id AS idPerformanceType, "
			+ "dev.description AS deviceDescription, "
			+ "dev.operatingSystem AS deviceOperatingSystem, "
			+ "dev.idPriceRange AS idPriceRange) "
			+ "FROM DevicePerformance dp "			
			+ "JOIN dp.key.performanceType pt on pt.id = :performanceType "
			+ "JOIN dp.key.device dev on dev.idPriceRange = :idPriceRange "
			)
	List<DeviceProjection> getKpiTopTenByPriceRange(@Param("idPriceRange") Long idPriceRange, @Param("performanceType") Long performanceType,Pageable pageable);
	 
}
