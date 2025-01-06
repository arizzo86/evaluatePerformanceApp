package com.griglie.evaluatePerformanceApp.persistence.entities;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Setter
@Table(name = "PRICE_RANGE")
public class PriceRange implements Serializable {
    private static final long serialVersionUID = -3805544452344967627L;

    private Long id;
    private String description;
    private String shortDescription;

    @Id
    @Column(name = "ID", insertable=false, updatable=false)
    public Long getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
    
    @Column(name = "SHORT_DESCRIPTION")
	public String getShortDescription() {
		return shortDescription;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceRange)) return false;
        PriceRange other = (PriceRange) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
