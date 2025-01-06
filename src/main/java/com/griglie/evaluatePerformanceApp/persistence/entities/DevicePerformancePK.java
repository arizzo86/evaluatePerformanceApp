package com.griglie.evaluatePerformanceApp.persistence.entities;


import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Setter
public class DevicePerformancePK implements Serializable {
    private static final long serialVersionUID = -3805544452344967627L;

    private Device device;
    
    private PerformanceType performanceType;    


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DEVICE")
	public Device getDevice() {
		return device;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERFORMANCE_TYPE")
	public PerformanceType getPerformanceType() {
		return performanceType;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevicePerformancePK)) return false;
        DevicePerformancePK other = (DevicePerformancePK) o;
        return device != null && device.equals(other.getDevice())&&
        		performanceType != null && performanceType.equals(other.getPerformanceType());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
