package com.software.newbii.domain.member;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MemberRole {
  USER("피보호자"),
  GUARDIAN("보호자"); // 보호자

  private final String description;
}