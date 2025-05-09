package com.software.newbii.domain.location.controller;

import com.software.newbii.domain.location.dto.LocationRequest;
import com.software.newbii.domain.location.dto.LocationResponse;
import com.software.newbii.domain.location.service.LocationService;
import com.software.newbii.domain.location.swagger.PostNewLocation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
@Tag(name = "위치", description = "위치 api")
public class LocationController {
    private final LocationService locationService;

    // 상위 2개 주기 방문 장소 조회 (RECORDED 중 visitCount 내림차순)
    @GetMapping("/frequent")
    public List<LocationResponse> getFrequent(
            @RequestParam Long memberId) {
        return locationService.getTopFrequent(memberId);
    }

    // 즐겨찾기 3곳 조회
    @GetMapping("/favorites")
    public List<LocationResponse> getFavorites(
            @RequestParam Long memberId) {
        return locationService.getFavorites(memberId);
    }

    @GetMapping("/home")
    public LocationResponse getHome(
            @RequestParam Long memberId) {
        return locationService.getHome(memberId);
    }

//    // 즐겨찾기 추가/삭제
//    @PostMapping("/favorites")
//    public void toggleFavorite(
//            @RequestParam Long memberId,
//            @RequestBody LocationRequest req) {
//        locationService.toggleFavorite(memberId, req);
//    }

    @PostMapping("/home")
    public void setHome(
            @RequestParam Long memberId,
            @RequestBody LocationRequest req) {
        locationService.setHome(memberId, req);
    }

    @PostNewLocation
    @PostMapping
    public String updateLocation(@RequestBody LocationRequest request, Long memberId) {
        return locationService.update(request, memberId);
    }

}
