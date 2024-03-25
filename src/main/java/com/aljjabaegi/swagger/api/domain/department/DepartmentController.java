package com.aljjabaegi.swagger.api.domain.department;

import com.aljjabaegi.swagger.api.domain.department.record.DepartmentSearchResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 부서 조회 편집 Controller
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@RestController
@Tag(name = "[API-002] 부서 정보 조회, 편집", description = "[담당자 : GEONLEE]")
@RequestMapping("/v2")
public class DepartmentController {

    /**
     * 부서 조회
     *
     * @param departmentName 부서명
     * @return DepartmentSearchResponse 부서 조회 응답
     * @author GEONLEE
     * @since 2024-03-24
     */
    @GetMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "부서 정보 조회", description = """
            # Parameters
            - departmentName [부서 이름]<font color='red'>*</font>
            """,
            operationId = "API-002-01"
    )
    public ResponseEntity<List<DepartmentSearchResponse>> getDepartment(@RequestParam("departmentName")
                                                                        @Parameter(name = "departmentName", description = "부서 명", example = "부서")
                                                                        String departmentName) {
        List<DepartmentSearchResponse> list = List.of(new DepartmentSearchResponse("DEPARTMENT_001", "개발부서"));
        return ResponseEntity.ok(list);
    }
}
