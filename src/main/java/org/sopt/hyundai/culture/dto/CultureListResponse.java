package org.sopt.hyundai.culture.dto;

import java.util.List;

public record CultureListResponse(
        List<CultureResponse> dataList
) {
    public static CultureListResponse of(List<CultureResponse> cultureList){
        return new CultureListResponse(cultureList);
    }
}
