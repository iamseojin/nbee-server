package com.software.newbii.domain.location;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LocationType {
  RECORDED,    // 주기적으로 찍히는 위치
  FAVORITE,    // 즐겨찾기 위치
  HOME
}
