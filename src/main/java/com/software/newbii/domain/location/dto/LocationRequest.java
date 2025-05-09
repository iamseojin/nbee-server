package com.software.newbii.domain.location.dto;

import com.software.newbii.domain.location.LocationType;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class LocationRequest {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private String locationName;
    private LocationType locationType;
    private Integer visitCount;
    private LocalDateTime lastVisitedAt;
}
