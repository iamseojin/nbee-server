package com.software.newbii.domain.location.repository;

import com.software.newbii.domain.location.Location;
import com.software.newbii.domain.location.LocationType;
import com.software.newbii.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location,Long> {
    // 기존 위치 조회
    Optional<Location> findByLatitudeAndLongitude(BigDecimal lat, BigDecimal lon);

    // top 2 by visitCount
    List<Location> findTop2ByMemberAndLocationTypeOrderByVisitCountDesc(
            Member member, LocationType type);

    // favorites & home
    //List<Location> findByMemberAndLocationType(Member member, LocationType type);
    Optional<Location> findByMemberAndLocationType(Member member, LocationType type);
}

