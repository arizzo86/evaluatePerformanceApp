package com.griglie.evaluatePerformanceApp.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.griglie.evaluatePerformanceApp.persistence.builders.DeviceBuilder;
import com.griglie.evaluatePerformanceApp.persistence.entities.Device;
import com.griglie.evaluatePerformanceApp.persistence.repositories.DeviceRepository;

import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class DeviceService {
	
	@Autowired
    private DeviceRepository deviceRepository;  


    public List<Device> getAllDeviceData() {
        return deviceRepository.findAll();
    }
    
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

	public Device addDeviceData(Device device) {
		return deviceRepository.save(device);
		
	}

	@Transactional
	public Device saveOrUpdateDevice( String deviceDescription, String deviceOperatingSystem, Long idPriceRange) {	
		Device deviceEntity =deviceRepository.findAllByDescriptionAndOperatingSystem(deviceDescription, deviceOperatingSystem);	
		
		if(deviceEntity != null) {
			deviceRepository.update(deviceDescription, deviceOperatingSystem,idPriceRange);
			return deviceEntity; 
		}
		
		deviceEntity = DeviceBuilder.aDevice()
				.withDescription(deviceDescription)
				.withOperatingSystem(deviceOperatingSystem)
				.withIdPriceRange(idPriceRange)
				.build();	
		
		return deviceRepository.save(deviceEntity);		
	}

}
