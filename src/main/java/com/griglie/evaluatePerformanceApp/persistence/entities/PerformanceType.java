package com.griglie.evaluatePerformanceApp.persistence.entities;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Setter
@Table(name = "PERFORMANCE_TYPES")
public class PerformanceType implements Serializable {
    private static final long serialVersionUID = -3805544452344967627L;

    private Long id;
    private String description;

    @Id
    @Column(name = "ID", insertable=false, updatable=false)
    public Long getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerformanceType)) return false;
        PerformanceType other = (PerformanceType) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
