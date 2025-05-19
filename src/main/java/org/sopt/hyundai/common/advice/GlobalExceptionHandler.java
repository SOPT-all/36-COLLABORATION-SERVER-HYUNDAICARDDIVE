package org.sopt.hyundai.common.advice;

import org.sopt.hyundai.common.code.ErrorCode;
import org.sopt.hyundai.common.response.ResponseDto;
import org.sopt.hyundai.exception.InvalidCategoryException;
import org.sopt.hyundai.exception.InvalidSortOptionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidSortOptionException.class)
    public ResponseEntity<ResponseDto<Void>> handleInvalidSortOptionException(Exception e) {
        return ResponseEntity
                .status(ErrorCode.INVALID_SORT_OPTION.getHttpStatus())
                .body(ResponseDto.fail(ErrorCode.INVALID_SORT_OPTION));
    }

    @ExceptionHandler(InvalidCategoryException.class)
    public ResponseEntity<ResponseDto<Void>> handleInvalidCategoryException(Exception e) {
        return ResponseEntity
                .status(ErrorCode.INVALID_CATEGORY.getHttpStatus())
                .body(ResponseDto.fail(ErrorCode.INVALID_CATEGORY));
    }

    // @Valid 예외
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<Map<String, String>>> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage())
        );

        return ResponseEntity
                .status(ErrorCode.INVALID_INPUT_VALUE.getHttpStatus())
                .body(ResponseDto.fail(ErrorCode.INVALID_INPUT_VALUE.getCode(), errors));
    }

    // 존재하지 않는 요청에 대한 예외
    @ExceptionHandler(value = {NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ResponseDto<Void>> handleNoPageFoundException(Exception e) {
        ErrorCode errorCode = e instanceof HttpRequestMethodNotSupportedException
                ? ErrorCode.METHOD_NOT_ALLOWED
                : ErrorCode.NOT_FOUND_END_POINT;

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ResponseDto.fail(errorCode));
    }

    // 기본 예외
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<Void>> handleException(Exception e){
        return ResponseEntity
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus())
                .body(ResponseDto.fail(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}
