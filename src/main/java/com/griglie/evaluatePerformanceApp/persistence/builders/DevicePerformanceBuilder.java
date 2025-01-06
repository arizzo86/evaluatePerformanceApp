package com.griglie.evaluatePerformanceApp.persistence.builders;



import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

import com.griglie.evaluatePerformanceApp.persistence.entities.DevicePerformance;
import com.griglie.evaluatePerformanceApp.persistence.entities.DevicePerformancePK;

public final class DevicePerformanceBuilder {
	private DevicePerformancePK key;
    private BigDecimal result;

    private DevicePerformanceBuilder() {
    }

    public static DevicePerformanceBuilder aDevicePerformance() {
        return new DevicePerformanceBuilder();
    }

    public DevicePerformanceBuilder withKey(DevicePerformancePK key) {
        this.key = key;
        return this;
    }

    public DevicePerformanceBuilder withResult(BigDecimal result) {
        this.result = result;
        return this;
    }
    
    public DevicePerformance build() {
    	DevicePerformance devicePerformance = new DevicePerformance();
    	devicePerformance.setKey(key);
    	devicePerformance.setResult(result);
    	devicePerformance.setLastModifiedDate(Timestamp.from(Instant.now()));
    	devicePerformance.setCreationDate(Timestamp.from(Instant.now()));
        return devicePerformance;
    }
}
