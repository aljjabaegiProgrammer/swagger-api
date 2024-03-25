package com.aljjabaegi.swagger.api.domain.department.record;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 부서 조회 응답 record
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@Schema(description = "부서 조회 응답")
public record DepartmentSearchResponse(
        @Schema(description = "부서 ID", example = "DEPARTMENT_001")
        String departmentId,
        @Schema(description = "멤버 이름", example = "개발부서")
        String departmentName) {
}
