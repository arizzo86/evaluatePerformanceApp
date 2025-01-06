package com.griglie.evaluatePerformanceApp.persistence.entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Setter
@Table(name = "DEVICE_PERFORMANCE")
public class DevicePerformance implements Serializable {
    private static final long serialVersionUID = -3805544452344967627L;

    private DevicePerformancePK key;
    private BigDecimal result;
    private Timestamp creationDate;
    private Timestamp lastModifiedDate;
    

    @EmbeddedId
    public DevicePerformancePK getKey() {
        return key;
    }

	@Column(name = "result")
	public BigDecimal getResult() {
		return result;
	}
		
    
	@CreationTimestamp
	@Column(name = "creation_date", updatable = false)
	public Timestamp getCreationDate() {
	     return creationDate;
	}


	@UpdateTimestamp
	@Column(name = "last_modified_date")
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}
	

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevicePerformance)) return false;
        DevicePerformance other = (DevicePerformance) o;
        return key != null && key.equals(other.getKey());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
