package com.software.newbii.domain.member.dto;


import java.time.LocalDate;

import com.software.newbii.domain.member.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class MemberDto {

  private Long id;
  private String email;
  private MemberRole role;
  private String name;
  private LocalDate birth;
  private String phone;
  private Long guardianId;
  private Long userId;

}
