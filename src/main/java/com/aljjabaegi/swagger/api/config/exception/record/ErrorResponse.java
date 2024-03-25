package com.aljjabaegi.swagger.api.config.exception.record;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 공통 에러 응답
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@Schema(description = "공통 에러 응답")
public record ErrorResponse(
        @Schema(description = "응답 상태", example = "500")
        Integer status,
        @Schema(description = "응답 메시지", example = "에러 응답 메시지")
        String message) {
}