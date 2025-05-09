package com.software.newbii.global.exception.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.software.newbii.global.exception.BaseException;
import com.software.newbii.global.exception.error.ErrorDisplayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@JsonPropertyOrder({"code", "message", "displayType"})
@Builder
public class ErrorResponse {

    @JsonProperty("code")
    private final String code;
    private final String message;
    private final ErrorDisplayType displayType;

    public static ErrorResponse generateErrorResponse(BaseException baseException){
        if(baseException.hasCustomMessage()) {
            return new ErrorResponse(
                    baseException.getErrorCode().getCode(),
                    baseException.getCustomErrorMessage(),
                    baseException.getErrorCode().getDisplayType());
        }
        return new ErrorResponse(
                baseException.getErrorCode().getCode(),
                baseException.getErrorCode().getMessage(),
                baseException.getErrorCode().getDisplayType());
    }
}
