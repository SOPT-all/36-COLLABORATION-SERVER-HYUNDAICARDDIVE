package org.sopt.hyundai.space.dto;

import org.sopt.hyundai.space.domain.ReviewEntity;

public record ReviewDto(
    String imageUrl,
    String reviewer,
    Integer likeCount
) {
    public static ReviewDto from(ReviewEntity entity) {
        return new ReviewDto(
            entity.getImageUrl(),
            entity.getReviewer(),
            entity.getLikeCount()
        );
    }
}
