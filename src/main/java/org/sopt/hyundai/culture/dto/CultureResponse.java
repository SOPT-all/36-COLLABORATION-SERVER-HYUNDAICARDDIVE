package org.sopt.hyundai.culture.dto;

import org.sopt.hyundai.culture.domain.Culture;

public record CultureResponse(
        Long id,
        String date,
        String title,
        String description,
        String stage,
        String location,
        boolean reservation,
        String image
) {
    public static CultureResponse from(Culture culture) {
        return new CultureResponse(
                culture.getId(),
                culture.getDate(),
                culture.getTitle(),
                culture.getDescription(),
                culture.getStage().getKorean(),
                culture.getLocation(),
                culture.isReservation(),
                culture.getImage()
        );
    }
}