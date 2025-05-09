package com.software.newbii.domain.location.dto;

import com.software.newbii.domain.location.Location;
import com.software.newbii.domain.location.LocationType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class LocationResponse {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String locationName;
    private LocationType locationType;
    private Integer visitCount;
    private LocalDateTime lastVisitedAt;

    public static LocationResponse of(Location location){
        return LocationResponse.builder()
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .locationName(location.getLocationName())
                .locationType(location.getLocationType())
                .visitCount(location.getVisitCount())
                .lastVisitedAt(location.getLastVisitedAt())
                .build();
    }
}
