package com.software.newbii.domain.location.service;

import com.software.newbii.domain.location.Location;
import com.software.newbii.domain.location.dto.LocationRequest;
import com.software.newbii.domain.location.repository.LocationRepository;
import com.software.newbii.domain.member.Member;
import com.software.newbii.domain.member.repository.MemberRepository;
import com.software.newbii.global.exception.BaseException;
import com.software.newbii.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationService {

    private final LocationRepository locationRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public String save(LocationRequest request, Long memberId) {
        BigDecimal lat = request.getLatitude();
        BigDecimal lon = request.getLongitude();

        Member member = loadMemberOrThrow(memberId);
        //Location location = Location.from(request);

        // 동일한 좌표가 이미 있나?
        Optional<Location> location = locationRepository.findByLatitudeAndLongitude(lat, lon);
        log.info("기존 위치가 존재합니다($lat, $lon) : "+ lat + ", " + lon + "");

        if (location.isPresent()) {
            // 있으면 방문 횟수 +1, 마지막 방문 시간 갱신
            Location loc = location.get();
            loc.setVisitCount(loc.getVisitCount() + 1);
            loc.setLastVisitedAt(LocalDateTime.now());
            locationRepository.save(loc);

            // JPA의 dirty-checking으로 자동 업데이트
            return "방문 정보가 업데이트되었습니다.";
        }

        // 신규 위치면 새로 저장
        Location newLoc = registerLocation(request, memberId);
        locationRepository.save(newLoc);

        return "등록 되었습니다";
    }

    private static Location registerLocation(LocationRequest request, Long memberId) {
        return Location.builder()
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())  // 수정
                .locationType(request.getLocationType())  // 추가
                .locationName(request.getLocationName())  // 추가
                .visitCount(1)
                .lastVisitedAt(LocalDateTime.now())
                .build();
    }

    private Member loadMemberOrThrow(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> BaseException.from(ErrorCode.MEMBER_NOT_FOUND));
    }

    private Location loadLocationOrThrow(Long locationId){
        return locationRepository.findById(locationId)
                .orElseThrow(() -> BaseException.from(ErrorCode.LOCATION_NOT_FOUND));
    }
}