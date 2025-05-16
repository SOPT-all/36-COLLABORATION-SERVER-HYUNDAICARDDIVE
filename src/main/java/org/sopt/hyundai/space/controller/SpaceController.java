package org.sopt.hyundai.space.controller;

import org.sopt.hyundai.common.code.SuccessCode;
import org.sopt.hyundai.common.response.ResponseDto;
import org.sopt.hyundai.space.dto.SpaceCultureResponse;
import org.sopt.hyundai.space.dto.SpaceDetailResponse;
import org.sopt.hyundai.space.service.SpaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/space")
public class SpaceController {
    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto<SpaceCultureResponse>> getSpaceCulture() {
        SpaceCultureResponse response = spaceService.getSpaceCulture();
        return ResponseEntity
                .status(SuccessCode.OK.getHttpStatus())
                .body(ResponseDto.success(SuccessCode.OK, response, SuccessCode.GET_SPACE_CULTURE.getMessage()));
    }

    @GetMapping("/details")
    public ResponseEntity<ResponseDto<SpaceDetailResponse>> getSpaceDetail() {
        SpaceDetailResponse response = spaceService.getSpaceDetail();
        return ResponseEntity
                .status(SuccessCode.OK.getHttpStatus())
                .body(ResponseDto.success(SuccessCode.OK, response, SuccessCode.GET_SPACE_DETAIL.getMessage()));
    }
}
