package com.software.newbii.domain.location.controller;

import com.software.newbii.domain.location.dto.LocationRequest;
import com.software.newbii.domain.location.service.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
@Tag(name = "동행", description = "동행 api 정보")
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public String createNewLocation(@RequestBody LocationRequest request, Long memberId) {
        return locationService.save(request, memberId);
    }


}
