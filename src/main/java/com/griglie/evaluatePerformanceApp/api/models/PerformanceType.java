package com.griglie.evaluatePerformanceApp.api.models;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName="of")
public class PerformanceType {
	@NotNull
    private String id;
	@NotNull
    private String description;

}
