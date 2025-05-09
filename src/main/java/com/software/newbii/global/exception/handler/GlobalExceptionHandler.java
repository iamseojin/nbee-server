package com.software.newbii.global.exception.handler;

import com.software.newbii.global.exception.BaseException;
import com.software.newbii.global.exception.error.ErrorCode;
import com.software.newbii.global.exception.error.ErrorDisplayType;
import com.software.newbii.global.exception.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {

    /**
     * 클라이언트 에러
     * 직접 생성한 예외에 대한 처리
     */
    @ExceptionHandler(BaseException.class)
    public ErrorResponse onThrowException(BaseException baseException) {
        return ErrorResponse.generateErrorResponse(baseException);
    }

    // TODO : 바인딩 에러 관련 ErrorCode 작성
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse onThrowException(MethodArgumentNotValidException exception){
        return ErrorResponse.builder()
                .code(ErrorCode.TMP_ERROR.getCode())
                .message(exception.getBindingResult().getFieldError().getDefaultMessage())
                .displayType(ErrorDisplayType.POPUP)
                .build();
    }
}
