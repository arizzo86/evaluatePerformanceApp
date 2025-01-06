package com.griglie.evaluatePerformanceApp.persistence;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.griglie.evaluatePerformanceApp.persistence.repositories.DeviceRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public abstract class BaseSpringTest {
    @Autowired
    protected DeviceRepository deviceRepository;
   
    @After
    public void tearDown() {      
    	deviceRepository.deleteAll();       
    }
}
