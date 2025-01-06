package com.griglie.evaluatePerformanceApp.persistence.builders;

import com.griglie.evaluatePerformanceApp.persistence.entities.Device;
import com.griglie.evaluatePerformanceApp.persistence.entities.DevicePerformancePK;
import com.griglie.evaluatePerformanceApp.persistence.entities.PerformanceType;

public final class DevicePerformancePKBuilder {
    private Device device;    
    private PerformanceType performanceType;    

    private DevicePerformancePKBuilder() {
    }

    public static DevicePerformancePKBuilder aDevicePerformancePK() {
        return new DevicePerformancePKBuilder();
    }

    public DevicePerformancePKBuilder withDevice(Device device) {
        this.device = device;
        return this;
    }

    public DevicePerformancePKBuilder withPerformanceType(PerformanceType performanceType) {
        this.performanceType = performanceType;
        return this;
    }


    public DevicePerformancePK build() {
    	DevicePerformancePK devicePerformancePK = new DevicePerformancePK();
    	devicePerformancePK.setDevice(device);
    	devicePerformancePK.setPerformanceType(performanceType);
        return devicePerformancePK;
    }
}
