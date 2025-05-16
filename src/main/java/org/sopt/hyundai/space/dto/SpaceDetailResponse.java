package org.sopt.hyundai.space.dto;

import org.sopt.hyundai.space.domain.SpaceEntity;

import java.util.List;

public record SpaceDetailResponse(
    String banner,
    String introduction,
    String address,
    List<ReviewDto> reviewList,
    String telephone,
    String email
) {
    public static SpaceDetailResponse from(SpaceEntity entity) {
        List<ReviewDto> reviewList = entity.getReviewList()
                .stream()
                .map(ReviewDto::from)
                .toList();
        return new SpaceDetailResponse(
                entity.getBanner(),
                entity.getIntroduction(),
                entity.getAddress(),
                reviewList,
                entity.getTelephone(),
                entity.getEmail()
        );
    }
}
