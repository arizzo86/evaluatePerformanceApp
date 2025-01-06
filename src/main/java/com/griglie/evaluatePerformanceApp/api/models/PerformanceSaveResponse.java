package com.griglie.evaluatePerformanceApp.api.models;


import java.math.BigDecimal;
import java.time.Instant;

import com.griglie.evaluatePerformanceApp.persistence.entities.Device;
import com.griglie.evaluatePerformanceApp.persistence.entities.DevicePerformance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceSaveResponse  {


	private Long idPerformanceType;
    private BigDecimal result; 
    private Instant executionDate;
    private String deviceDescription;
    private String deviceOperatingSystem;
    private Long idPriceRange;
    private Long position; 
   
    public PerformanceSaveResponse(DevicePerformance dp, Device device, Long position) {
		this.result=dp.getResult();
		this.idPerformanceType= dp.getKey().getPerformanceType().getId();
		this.executionDate=dp.getCreationDate().toInstant();
		this.deviceDescription=device.getDescription();
		this.deviceOperatingSystem=device.getOperatingSystem();
		this.idPriceRange=device.getIdPriceRange(); 
		this.position= position;
	}
}
