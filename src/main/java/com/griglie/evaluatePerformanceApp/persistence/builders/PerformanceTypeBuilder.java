package com.griglie.evaluatePerformanceApp.persistence.builders;

import com.griglie.evaluatePerformanceApp.persistence.entities.PerformanceType;

public final class PerformanceTypeBuilder {
    private Long id;
    private String description;

    private PerformanceTypeBuilder() {
    }

    public static PerformanceTypeBuilder aPriceRangeBuilder() {
        return new PerformanceTypeBuilder();
    }

    public PerformanceTypeBuilder withId(Long id) {
        this.id = id;
        return this;
    }
    
    public PerformanceTypeBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

  

    public PerformanceType build() {
    	PerformanceType performanceType = new PerformanceType();
    	performanceType.setId(id);
    	performanceType.setDescription(description);
        return performanceType;
    }
}
