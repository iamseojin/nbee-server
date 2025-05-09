package com.software.newbii.domain.location.swagger;

import com.software.newbii.domain.location.dto.LocationResponse;
import com.software.newbii.global.exception.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "위치 정보 신규 생성 및 업데이트",
        description = "위치 정보 신규 생성 및 변경 사항을 DB에 저장합니다.")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "위치 정보 저장에 성공하였습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = LocationResponse.class))),
        @ApiResponse(responseCode = "4xx", description = "요청 처리 실패",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorResponse.class)))
})
public @interface PostNewLocation {
}

