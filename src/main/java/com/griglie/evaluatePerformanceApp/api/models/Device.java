package com.griglie.evaluatePerformanceApp.api.models;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName="of")
public class Device{
    
	private Long devicePosition;
    private BigDecimal resultValue; 
    private Long idPerformanceType;
    private String deviceDescription;
    private String deviceOperatingSystem;
    private Long idPriceRange;
}
