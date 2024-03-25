package com.aljjabaegi.swagger.api.config.exception;

import com.aljjabaegi.swagger.api.config.exception.record.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;

/**
 * 전역 Exception Handler
 *
 * @author GEONLEE
 * @since 2024-03-24
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 500 Internal server error 응답 처리
     *
     * @return ErrorResponse
     * @author GEONLEE
     * @since 2024-03-24
     */
    @ExceptionHandler(value = {IOException.class, NoSuchMethodError.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return ResponseEntity.ok()
                .header("Content-type", String.valueOf(MediaType.APPLICATION_JSON))
                .body(new ErrorResponse(500, "서버 오류입니다."));
    }

    /**
     * 404 Not found 응답 처리
     *
     * @return ErrorResponse
     * @author GEONLEE
     * @since 2024-03-24
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNotFoundError(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return ResponseEntity.ok()
                .header("Content-type", String.valueOf(MediaType.APPLICATION_JSON))
                .body(new ErrorResponse(404, "요청하신 페이지를 찾을 수 없습니다."));
    }
}
