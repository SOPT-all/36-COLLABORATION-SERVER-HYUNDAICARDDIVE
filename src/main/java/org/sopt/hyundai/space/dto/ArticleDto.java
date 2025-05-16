package org.sopt.hyundai.space.dto;

import org.sopt.hyundai.space.domain.ArticleEntity;

public record ArticleDto(
    String imageUrl,
    String title,
    String subTitle,
    String date
) {
    public static ArticleDto from(ArticleEntity entity) {
        return new ArticleDto(
            entity.getImageUrl(),
            entity.getTitle(),
            entity.getSubTitle(),
            entity.getDate()
        );
    }
}
