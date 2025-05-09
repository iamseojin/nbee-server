package com.software.newbii.global.config;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeoConfig {
    @Bean
    public GeometryFactory geometryFactory() {
        // WGS84 좌표계 (4326) 에 대응
        return new GeometryFactory(new PrecisionModel(), 4326);
    }
}
