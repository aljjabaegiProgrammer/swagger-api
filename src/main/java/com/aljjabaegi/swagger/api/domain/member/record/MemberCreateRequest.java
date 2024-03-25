package com.aljjabaegi.swagger.api.domain.member.record;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 멤버 추가 요청 record
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@Schema(description = "멤버 추가 요청")
public record MemberCreateRequest(
        @Schema(description = "멤버 ID", example = "geonlee")
        @NotNull
        @Size(min = 2, max = 50)
        String memberId,
        @Schema(description = "멤버 이름", example = "이건")
        @Size(min = 2, max = 100)
        String memberName) {
}