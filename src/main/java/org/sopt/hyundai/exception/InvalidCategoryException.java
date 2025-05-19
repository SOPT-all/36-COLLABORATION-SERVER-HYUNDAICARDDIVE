package org.sopt.hyundai.exception;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.code.ErrorCode;

@RequiredArgsConstructor
public class InvalidCategoryException extends RuntimeException{

    private final ErrorCode errorCode;
}