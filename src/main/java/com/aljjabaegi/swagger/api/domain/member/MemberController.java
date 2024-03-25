package com.aljjabaegi.swagger.api.domain.member;

import com.aljjabaegi.swagger.api.domain.member.record.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 멤버 조회 편집 Controller
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@RestController
@Tag(name = "[API-001] 멤버 정보 조회, 편집", description = "[담당자 : GEONLEE]")
@RequestMapping("/v1")
public class MemberController {

    /**
     * 멤버 조회
     *
     * @author GEONLEE
     * @since 2024-03-24
     */
    @GetMapping(value = "/members/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "멤버 정보 조회", description = """
            # Parameters
            - memberId [멤버 ID] <font color='red'>*</font>
            - memberName [멤버 이름]
            """,
            operationId = "API-001-01"
    )
    public ResponseEntity<MemberSearchResponse> getMember(@PathVariable("memberId")
                                                          @Parameter(name = "memberId", description = "멤버 ID", example = "geonlee")
                                                          String memberId) {
        return ResponseEntity.ok(new MemberSearchResponse("geonlee", "이건"));
    }

    /**
     * 멤버 추가
     *
     * @author GEONLEE
     * @since 2024-03-24
     */
    @PostMapping(value = "/member", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "멤버 정보 추가", description = """
            # Parameters
            - memberId [멤버 ID] <font color='red'>*</font>
            - memberName [멤버 이름]
            """,
            operationId = "API-001-02"
    )
    public ResponseEntity<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
        return ResponseEntity.ok(new MemberCreateResponse("geonlee", "이건", "2024-03-24 00:00:00"));
    }

    /**
     * 멤버 수정
     *
     * @author GEONLEE
     * @since 2024-03-24
     */
    @PutMapping(value = "/member", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "멤버 정보 수정", description = """
            # Parameters
            - memberId [멤버 ID] <font color='red'>*</font>
            - memberName [멤버 이름]
            """,
            operationId = "API-001-03"
    )
    public ResponseEntity<MemberModifyResponse> createMember(@RequestBody MemberModifyRequest memberModifyRequest) {
        return ResponseEntity.ok(new MemberModifyResponse("geonlee", "이건", "2024-03-24 00:00:00"));
    }

    /**
     * 멤버 삭제
     *
     * @author GEONLEE
     * @since 2024-03-24
     */
    @DeleteMapping(value = "/member", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "멤버 정보 삭제", description = """
            # Parameters
            - memberId [멤버 ID] <font color='red'>*</font>
            """,
            operationId = "API-001-04"
    )
    public ResponseEntity<Long> createMember(@RequestBody MemberDeleteRequest memberDeleteRequest) {
        return ResponseEntity.ok(1L);
    }
}