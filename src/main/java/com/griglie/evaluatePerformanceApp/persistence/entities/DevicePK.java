package com.griglie.evaluatePerformanceApp.persistence.entities;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Setter
public class DevicePK implements Serializable {
    private static final long serialVersionUID = -3805544452344967627L;

    private String description;
    private String operatingSystem; 


    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name = "operating_system")
    public String getOperatingSystem() {
        return operatingSystem;
    }
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevicePK)) return false;
        DevicePK other = (DevicePK) o;
        return description != null && description.equals(other.getDescription())&&
        		operatingSystem != null && operatingSystem.equals(other.getOperatingSystem());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
