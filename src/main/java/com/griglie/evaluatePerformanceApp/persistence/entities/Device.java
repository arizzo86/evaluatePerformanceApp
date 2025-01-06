package com.griglie.evaluatePerformanceApp.persistence.entities;


import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
@Table(name = "DEVICE")
public class Device implements Serializable {
    private static final long serialVersionUID = -3805544452344967627L;

    private Long id;
    private String description;
    private String operatingSystem;
    private Long idPriceRange;
    private Timestamp creationDate;
    private Timestamp lastModifiedDate;


    @Id
    @SequenceGenerator(name="device_id_seq", sequenceName="device_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "device_id_seq")
    @Column(name = "ID", insertable=false, updatable=false)
    public Long getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name = "operating_system")
    public String getOperatingSystem() {
        return operatingSystem;
    }
    
	public Long getIdPriceRange() {
		return idPriceRange; 
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
        if (!(o instanceof Device)) return false;
        Device other = (Device) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
