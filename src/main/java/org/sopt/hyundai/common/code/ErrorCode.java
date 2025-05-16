package org.sopt.hyundai.common.code;

import org.springframework.http.HttpStatus;

public enum ErrorCode implements ApiCode{
    // 400
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, 400, "잘못된 요청 값입니다."),
    NOT_FOUND_RESOURCE(HttpStatus.NOT_FOUND, 404, "해당 리소스를 찾을 수 없습니다."),
    NOT_FOUND_END_POINT(HttpStatus.NOT_FOUND, 404, "요청한 API 엔드포인트가 존재하지 않습니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, 405, "지원하지 않는 HTTP 메서드입니다."),

    // 500
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "알 수 없는 서버 내부 오류입니다"),
    ;

    private final HttpStatus status;
    private final int code;
    private final String message;

    ErrorCode(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}