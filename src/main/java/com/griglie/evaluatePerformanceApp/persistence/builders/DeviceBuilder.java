package com.griglie.evaluatePerformanceApp.persistence.builders;

import java.sql.Timestamp;
import java.time.Instant;

import com.griglie.evaluatePerformanceApp.persistence.entities.Device;
import com.griglie.evaluatePerformanceApp.persistence.entities.PriceRange;

public final class DeviceBuilder {
    private Long id;
    private String description;
    private String operatingSystem;
    private Long idPriceRange;

    private DeviceBuilder() {
    }

    public static DeviceBuilder aDevice() {
        return new DeviceBuilder();
    }

    public DeviceBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DeviceBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public DeviceBuilder withOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }
    
    public DeviceBuilder withIdPriceRange(Long idPriceRange) {
        this.idPriceRange = idPriceRange;
        return this;
    }

    public Device build() {
    	Device device = new Device();
    	device.setId(id);
    	device.setDescription(description);
    	device.setOperatingSystem(operatingSystem);     
    	device.setIdPriceRange(idPriceRange);
    	device.setLastModifiedDate(Timestamp.from(Instant.now()));
    	device.setCreationDate(Timestamp.from(Instant.now()));
        return device;
    }
}
