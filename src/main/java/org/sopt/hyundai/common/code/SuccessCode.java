package org.sopt.hyundai.common.code;

import org.springframework.http.HttpStatus;

public enum SuccessCode implements ApiCode {
    OK(HttpStatus.OK, 200,"요청이 성공했습니다."),
    CREATED(HttpStatus.CREATED, 201, "요청이 성공했습니다."),
    NO_CONTENT(HttpStatus.NO_CONTENT,204,"요청이 성공했습니다.")
    ;

    public final HttpStatus httpStatus;
    private final int code;
    private final String message;

    SuccessCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

    @Override
    public int getCode(){
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}