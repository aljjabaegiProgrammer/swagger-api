package com.aljjabaegi.swagger.api.domain.member.record;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 멤버 삭제 요청 record
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@Schema(description = "멤버 삭제 요청")
public record MemberDeleteRequest(
        @Schema(description = "멤버 ID", example = "geonlee")
        String memberId) {
}
