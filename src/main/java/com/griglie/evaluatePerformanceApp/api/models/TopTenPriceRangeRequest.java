package com.griglie.evaluatePerformanceApp.api.models;

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
public class TopTenPriceRangeRequest {

	private Long idPerformanceType;
    private Long idPriceRange; 

}
