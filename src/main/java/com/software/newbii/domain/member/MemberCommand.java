package com.software.newbii.domain.member;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberCommand {

  private Long id;
  private String email;
  private MemberRole role;
  private String name;
  private LocalDate birth;
  private String phone;
  private Long guardianId;
  private Long userId;
  private String password;

}
