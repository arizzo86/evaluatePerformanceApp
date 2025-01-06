package com.griglie.evaluatePerformanceApp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griglie.evaluatePerformanceApp.api.models.PerformanceSaveRequest;
import com.griglie.evaluatePerformanceApp.api.models.PerformanceSaveResponse;
import com.griglie.evaluatePerformanceApp.api.models.TopTenDeviceResponse;
import com.griglie.evaluatePerformanceApp.api.models.TopTenPriceRangeRequest;
import com.griglie.evaluatePerformanceApp.api.models.TopTenSOPriceRangeRequest;
import com.griglie.evaluatePerformanceApp.api.services.DevicePerformanceService;
import com.griglie.evaluatePerformanceApp.api.services.DeviceService;
import com.griglie.evaluatePerformanceApp.mapper.DeviceMapper;
import com.griglie.evaluatePerformanceApp.persistence.entities.Device;
import com.griglie.evaluatePerformanceApp.persistence.entities.DevicePerformance;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deviceperformance")
public class DevicePerformanceController {
	private static final String SAVE_PERFORMANCE="/save";
	private static final String DEVICE_POSITION="/deviceposition";
	private static final String TOP_TEN_PRICE_RANGE="/topTenByPriceRange";
	private static final String TOP_TEN_SO_PRICE_RANGE="/topTenBySOPriceRange";
	
	@Autowired
    private DevicePerformanceService devicePerformanceService;  	
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceMapper deviceMapper;
	
    
    @PostMapping(value=SAVE_PERFORMANCE)
    public ResponseEntity<PerformanceSaveResponse> saveDevicePerformance (@RequestBody PerformanceSaveRequest performanceSaveRequest) {
    	String deviceDescription=performanceSaveRequest.getDeviceDescription().toUpperCase().trim();
    	String deviceOperationSystem=performanceSaveRequest.getDeviceOperatingSystem().toUpperCase().trim();
    	Long idPerformanceType =performanceSaveRequest.getIdPerformanceType();
    	Device device=deviceService.saveOrUpdateDevice(deviceDescription, deviceOperationSystem, performanceSaveRequest.getIdPriceRange());
    	DevicePerformance dp=devicePerformanceService.saveOrUpdateDevicePerformanceData(device,idPerformanceType,performanceSaveRequest.getResult()); 
    	Long position=devicePerformanceService.getDevicePositionByKpi(deviceDescription,deviceOperationSystem,idPerformanceType);
    	PerformanceSaveResponse performanceSaveResponse= new PerformanceSaveResponse(dp, device,position);
    	return  ResponseEntity.ok(performanceSaveResponse);	
    }
    
    @GetMapping(value = DEVICE_POSITION)
    public ResponseEntity<Long> getDevicePositionByKpi(@RequestBody PerformanceSaveRequest performanceSaveRequest){
    	return ResponseEntity.ok(devicePerformanceService.getDevicePositionByKpi(performanceSaveRequest.getDeviceDescription().toUpperCase().trim(),
    			performanceSaveRequest.getDeviceOperatingSystem().toUpperCase().trim(),
    			performanceSaveRequest.getIdPerformanceType()));	
    }
    
    @GetMapping(value=TOP_TEN_SO_PRICE_RANGE)
    public ResponseEntity<TopTenDeviceResponse> getDeviceOperatingSystemTopTenByPriceRange(@RequestBody TopTenSOPriceRangeRequest topTenPriceRangeRequest){
    		Pageable pageable= PageRequest.of(0,10, Sort.Direction.ASC, "devicePosition");
        	return  ResponseEntity.ok(deviceMapper.toTopTenDeviceResponse(
        			devicePerformanceService.getDeviceOperatingSystemTopTen(topTenPriceRangeRequest.getDeviceOperatingSystem().toUpperCase().trim(), 
        					topTenPriceRangeRequest.getIdPriceRange(), topTenPriceRangeRequest.getIdPerformanceType(), pageable)));	
    }
    
    @GetMapping(value=TOP_TEN_PRICE_RANGE)
    public ResponseEntity<TopTenDeviceResponse> getTopTenByPriceRange(@RequestBody TopTenPriceRangeRequest topTenPriceRangeRequest){
		Pageable pageable= PageRequest.of(0,10, Sort.Direction.ASC, "devicePosition");
    	return  ResponseEntity.ok(deviceMapper.toTopTenDeviceResponse(
    			devicePerformanceService.getDevicePriceRangeTopTen(topTenPriceRangeRequest.getIdPriceRange(), topTenPriceRangeRequest.getIdPerformanceType(), pageable)));	
}

    
  


}
