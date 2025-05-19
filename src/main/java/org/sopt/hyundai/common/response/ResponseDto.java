package org.sopt.hyundai.common.response;

import org.sopt.hyundai.common.code.ErrorCode;
import org.sopt.hyundai.common.code.SuccessCode;

public record ResponseDto<T>(
        int code,
        T data,
        String message
) {
    public static <T> ResponseDto<T> success(SuccessCode code, final T data) {
        return new ResponseDto<>(code.getCode(), data, null);
    }

    public static <T> ResponseDto<T> success(SuccessCode code, final T data, final String message) {
        return new ResponseDto<>(code.getCode(), data, message);
    }

    public static <T> ResponseDto<T> fail(ErrorCode code) {
        return new ResponseDto<>(code.getCode(), null, code.getMessage());
    }

    public static <T> ResponseDto<T> fail(int code, final T data) {
        return new ResponseDto<>(code, data, null);
    }
}