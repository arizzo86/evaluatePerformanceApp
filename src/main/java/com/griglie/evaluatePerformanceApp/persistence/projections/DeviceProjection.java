package com.griglie.evaluatePerformanceApp.persistence.projections;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceProjection {
	
	private Long devicePosition;
    private BigDecimal resultValue; 
    private Long idPerformanceType;
    private String deviceDescription;
    private String deviceOperatingSystem;
    private Long idPriceRange;
   
    public DeviceProjection(Long idPerformanceType, BigDecimal resultValue, 
    		String deviceDescription, String deviceOperatingSystem,  Long idPriceRange, Long devicePosition ) {
    	
		this.idPerformanceType= idPerformanceType;
		this.deviceDescription=deviceDescription;
		this.deviceOperatingSystem=deviceOperatingSystem;
		this.idPriceRange=idPriceRange; 
		this.resultValue= resultValue;
		this.devicePosition= devicePosition;
	}

}
