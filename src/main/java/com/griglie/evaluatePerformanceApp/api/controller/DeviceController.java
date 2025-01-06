package com.griglie.evaluatePerformanceApp.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.griglie.evaluatePerformanceApp.api.services.DeviceService;
import com.griglie.evaluatePerformanceApp.persistence.entities.Device;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class DeviceController {
	
	@Autowired
    private DeviceService deviceService;
    
    @GetMapping(value="/deviceData")
    public List<Device> getDeviceData() {
    	return deviceService.getAllDeviceData();
    }
    
    
    @GetMapping(value="/deviceData/{id}")
    public Optional<Device> getDeviceDataById(@PathVariable Long id) {
    	return deviceService.getDeviceById(id);
    }
    
    @PostMapping(value="/deviceData")
    public ResponseEntity<Device> addDeviceData(@RequestBody Device device) {
    	 Device d=deviceService.addDeviceData(device);
    	 System.out.println(d);
    	 return new ResponseEntity<Device>(device,HttpStatus.CREATED);		
    }

}
