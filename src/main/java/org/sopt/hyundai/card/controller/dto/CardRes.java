package org.sopt.hyundai.card.controller.dto;

import lombok.Builder;

import java.util.List;

public record CardRes(
        List<CardDto> cardList
) {
    @Builder
    public record CardDto(
            String title,
            String category,
            String hashTag,
            String imageUrl
    ){}
}