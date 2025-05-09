package com.software.newbii.domain.member.controller;

import com.software.newbii.domain.member.dto.MemberCommand;
import com.software.newbii.domain.member.dto.MemberDto;
import com.software.newbii.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Tag(
    name = "회원 관리 API",
    description = "회원 관리 API 제공"
)
public class MemberController {

  private final MemberService memberService;

  // 회원 정보 조회
  @PostMapping("/getMemberInfo")
  public ResponseEntity<MemberDto> getMemberInfo(
      @ModelAttribute MemberCommand command
  ) {
    return ResponseEntity.ok(memberService.getMemberInfo(command));
  }

  // 회원 생성
  @PostMapping("/create")
  public ResponseEntity<MemberDto> createMember(
      @ModelAttribute MemberCommand command
  ) {
    return ResponseEntity.ok(memberService.createMember(command));
  }

  // 회원 수정 (보호자만 user 지정 가능)
  @PostMapping("/update")
  public ResponseEntity<Void> updateMember(
      @ModelAttribute MemberCommand command
  ) {
    memberService.updateMember(command);
    return ResponseEntity.ok().build();
  }

  // 회원 삭제 (하드 삭제)
  @PostMapping("/delete")
  public ResponseEntity<Void> deleteMember(
      @ModelAttribute MemberCommand command
  ) {
    memberService.deleteMember(command.getId());
    return ResponseEntity.ok().build();
  }
}

