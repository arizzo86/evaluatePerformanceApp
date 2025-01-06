package com.griglie.evaluatePerformanceApp.persistence.repositories;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.griglie.evaluatePerformanceApp.persistence.BaseSpringTest;
import com.griglie.evaluatePerformanceApp.persistence.builders.DeviceBuilder;
import com.griglie.evaluatePerformanceApp.persistence.entities.Device;

public class DeviceRepositoryFindAllIT extends BaseSpringTest {
    @Autowired
    private DeviceRepository target;

       @Test
    public void shouldFilterByTitle() {
      deviceRepository.save(DeviceBuilder.aDevice()
                   .withId(1L)
                   .withDescription("Samsung A51")
                   .withOperatingSystem("android")
                   .build());
        List<Device> deviceList = target.findAll();
        Assertions.assertThat(deviceList).hasSize(1);
    }
}
