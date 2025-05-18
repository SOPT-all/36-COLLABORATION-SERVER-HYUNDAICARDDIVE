package org.sopt.hyundai.culture.dto;

import org.sopt.hyundai.culture.domain.Culture;

import java.util.List;

public record CultureListResponse(
        List<CultureResponse> cultureList
) {
    public static CultureListResponse from(List<CultureResponse> cultureList){
        return new CultureListResponse(cultureList);
    }
}
