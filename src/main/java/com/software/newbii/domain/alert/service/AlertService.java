package com.software.newbii.domain.alert.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlertService {
    /**
     * memberId 의 보호자에게
     * 위치(latitude, longitude)가 safeZone을 벗어났음을 알림으로 보낸다.
     */
    public void notifyGuardian(Long memberId, BigDecimal latitude, BigDecimal longitude)
    {

    }
}
