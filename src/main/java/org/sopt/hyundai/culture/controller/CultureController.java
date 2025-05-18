package org.sopt.hyundai.culture.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.code.SuccessCode;
import org.sopt.hyundai.common.response.ResponseDto;
import org.sopt.hyundai.culture.dto.CultureListResponse;
import org.sopt.hyundai.culture.dto.CultureResponse;
import org.sopt.hyundai.culture.service.CultureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CultureController {

    private final CultureService cultureService;

    @GetMapping("/culture")
    public ResponseEntity<ResponseDto<CultureListResponse>> getCulture(){
        CultureListResponse response = cultureService.getCulture();

        return ResponseEntity
                .status(SuccessCode.OK.getHttpStatus())
                .body(ResponseDto.success(SuccessCode.OK, response));
    }
}
