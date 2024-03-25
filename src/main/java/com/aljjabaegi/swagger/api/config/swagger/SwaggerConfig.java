package com.aljjabaegi.swagger.api.config.swagger;

import com.aljjabaegi.swagger.api.config.exception.record.ErrorResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Swagger 설정
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@OpenAPIDefinition(
        info = @Info(
                title = "API title",
                description = """
                        API Description
                        """,
                version = "v1.0.0",
                contact = @Contact(
                        name = "geonlee",
                        email = "geonlee@kakao.com"
                ),
                license = @License(
                        name = "Apache License Version 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )),
        servers = @Server(url = "/swagger-api"))
@SecurityScheme(
        name = "JWT Token",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi version1Api() {
        return GroupedOpenApi.builder()
                .group("v1.0")
                .pathsToMatch("/v1/**")
                .build();
    }

    @Bean
    public GroupedOpenApi version2Api() {
        return GroupedOpenApi.builder()
                .group("v2.0")
                .pathsToMatch("/v2/**")
                .build();
    }

    /**
     * Operation 의 기존 ApiResponse 에 공통 응답 추가
     */
    @Bean
    public OperationCustomizer operationCustomizer() {
        return (operation, handlerMethod) -> {
            ApiResponses apiResponses = operation.getResponses();
            if (apiResponses == null) {
                apiResponses = new ApiResponses();
                operation.setResponses(apiResponses);
            }
            apiResponses.putAll(getCommonResponses());
            return operation;
        };
    }

    /**
     * 공통 응답 정보를 생성하여 맵으로 리턴한다.
     *
     * @return LinkedHashMap<String, ApiResponse> ApiResponse Map
     */
    private Map<String, ApiResponse> getCommonResponses() {
        LinkedHashMap<String, ApiResponse> responses = new LinkedHashMap<>();
        responses.put("404", notFoundResponse());
        responses.put("500", internalServerResponse());
        return responses;
    }

    /**
     * 404 Response 를 생성하여 리턴
     *
     * @return ApiResponse 404 응답 객체
     */
    private ApiResponse notFoundResponse() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setDescription("""
                Not Found
                - 요청한 URI 가 올바른지 확인한다.
                """);
        addContent(apiResponse, 404, "Not Found");
        return apiResponse;
    }

    /**
     * 500 Response 를 생성하여 리턴
     *
     * @return ApiResponse 500 응답 객체
     */
    private ApiResponse internalServerResponse() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setDescription("""
                Internal Server Error (Unchecked Exception)
                - API 담당자에게 오류 확인을 요청한다.
                """);
        addContent(apiResponse, 500, "Internal Server Error");
        return apiResponse;
    }

    /**
     * ApiResponse 의 Content 정보를 추가
     *
     * @param apiResponse Api 응답 객체
     * @param status      응답 상태 코드
     * @param message     응답 메시지
     */
    @SuppressWarnings("rawtypes")
    private void addContent(ApiResponse apiResponse, int status, String message) {
        Content content = new Content();
        MediaType mediaType = new MediaType();
        Schema schema = new Schema<>();
        schema.$ref("#/components/schemas/ErrorResponse");
        mediaType.schema(schema).example(new ErrorResponse(status, message));
        content.addMediaType("application/json", mediaType);
        apiResponse.setContent(content);
    }
}
