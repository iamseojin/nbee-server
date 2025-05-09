package com.software.newbii.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    TMP_ERROR("S3-0000", "파일 형식이 올바르지 않습니다.", ErrorDisplayType.MODAL),

    //client error : 4xx

    //member
    MEMBER_NOT_FOUND("MEM-0000", "해당 회원이 존재하지 않습니다.", ErrorDisplayType.POPUP),
    MEMBER_ALREADY_REGISTERED("MEM-0001", "이미 회원가입되어 있습니다.", ErrorDisplayType.POPUP),
    EMAIL_ALREADY_EXISTS("MEM-0002", "이미 사용 중인 이메일입니다.", ErrorDisplayType.POPUP),

    //token
    TOKEN_NOT_FOUND("TKN-0000", "refresh token이 존재하지 않습니다.", ErrorDisplayType.POPUP),
    INVALID_TOKEN("TKN-0001", "유효하지 않은 token입니다.", ErrorDisplayType.POPUP),

    //location
    LOCATION_NOT_FOUND("LOC-0000", "location이 존재하지 않습니다.", ErrorDisplayType.POPUP)
    ;


    private final String code;
    private final String message;
    private final ErrorDisplayType displayType;
}
