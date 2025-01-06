package com.griglie.evaluatePerformanceApp.api.models;


import java.time.Instant;

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
public class DevicePerformance  {

    private Long idPerformanceType;
    private Long result; 
    private Instant creationDate;

   
}
