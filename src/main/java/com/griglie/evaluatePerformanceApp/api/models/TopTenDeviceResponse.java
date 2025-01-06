package com.griglie.evaluatePerformanceApp.api.models;


import java.util.List;

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
public class TopTenDeviceResponse  {
	
	private List<Device> deviceModelList;
	

}
