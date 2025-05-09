package com.software.newbii.domain.location;


import com.software.newbii.domain.member.Member;
import com.software.newbii.global.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

public class Location extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  //위도
  @Column(nullable = false, precision = 9, scale = 6)
  private BigDecimal latitude;

  //경도
  @Column(nullable = false, precision = 9, scale = 6)
  private BigDecimal longitude;

  private String LocationName;

  @Column(nullable = false)
  private LocationType locationType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

}

