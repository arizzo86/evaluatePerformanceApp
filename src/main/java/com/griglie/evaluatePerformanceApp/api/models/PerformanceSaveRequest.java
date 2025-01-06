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
@AllArgsConstructor
public class PerformanceSaveRequest  {

    private Long idPerformanceType;
    private BigDecimal result; 
    private String deviceDescription;
    private String deviceOperatingSystem;
    private Long idPriceRange; 

   
}
