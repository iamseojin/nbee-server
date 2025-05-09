package com.software.newbii.domain.location.repository;

import com.software.newbii.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findById();

    Optional<Location> findByLatitudeAndLongitude(BigDecimal lat, BigDecimal lon);
}
