package com.griglie.evaluatePerformanceApp.api.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.griglie.evaluatePerformanceApp.persistence.builders.DevicePerformanceBuilder;
import com.griglie.evaluatePerformanceApp.persistence.builders.DevicePerformancePKBuilder;
import com.griglie.evaluatePerformanceApp.persistence.builders.PerformanceTypeBuilder;
import com.griglie.evaluatePerformanceApp.persistence.entities.Device;
import com.griglie.evaluatePerformanceApp.persistence.entities.DevicePerformance;
import com.griglie.evaluatePerformanceApp.persistence.projections.DeviceProjection;
import com.griglie.evaluatePerformanceApp.persistence.repositories.DevicePerformanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class DevicePerformanceService {
	
	@Autowired
    private DevicePerformanceRepository devicePerformanceRepository;  


	public DevicePerformance saveDevicePerformanceData(DevicePerformance devicePerformance) {
		return devicePerformanceRepository.save(devicePerformance);
		
	}

	@Transactional
	public DevicePerformance saveOrUpdateDevicePerformanceData(Device device, Long idPerformanceType, BigDecimal result) {
		DevicePerformance devicePerformanceEntity= DevicePerformanceBuilder
				.aDevicePerformance()
				.withKey(DevicePerformancePKBuilder
						.aDevicePerformancePK()
						.withDevice(device)
						.withPerformanceType(PerformanceTypeBuilder.aPriceRangeBuilder().withId(idPerformanceType).build()).build())
				.withResult(result)
				.build();
		return devicePerformanceRepository.save(devicePerformanceEntity);
	}
	
	public Long getDevicePositionByKpi(String deviceDescription, String deviceOperatingSystem, Long idPerformanceType) {
		return devicePerformanceRepository.getKpiPositionByDescriptionAndOperatingSystem(deviceDescription, deviceOperatingSystem, idPerformanceType);

	}

	public List<DeviceProjection> getDeviceOperatingSystemTopTen(String operatingSystem, Long idPriceRange, Long idPerformanceType, Pageable pageable) {
		return devicePerformanceRepository.getKpiTopTenByOperatingSystemAndPriceRange(operatingSystem, idPriceRange, idPerformanceType, pageable);
	}

	public List<DeviceProjection> getDevicePriceRangeTopTen(Long idPriceRange, Long idPerformanceType, Pageable pageable) {
		return devicePerformanceRepository.getKpiTopTenByPriceRange(idPriceRange, idPerformanceType, pageable);
	}


}
