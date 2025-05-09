package com.software.newbii.domain.location.dto;

import com.software.newbii.domain.location.Location;
import com.software.newbii.domain.location.LocationType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class LocationAlertResponse {
    private Long memberId;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public static LocationResponse of(Location location){
        return LocationResponse.builder()
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
    }
}

