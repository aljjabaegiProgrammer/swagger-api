package com.aljjabaegi.swagger.api.domain.member.record;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 멤버 조회 응답 record
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@Schema(description = "멤버 조회 응답")
public record MemberSearchResponse(
        @Schema(description = "멤버 ID", example = "geonlee")
        String memberId,
        @Schema(description = "멤버 이름", example = "이건")
        String memberName) {
}
