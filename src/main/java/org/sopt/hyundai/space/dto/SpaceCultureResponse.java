package org.sopt.hyundai.space.dto;

import org.sopt.hyundai.space.domain.SpaceEntity;

import java.util.List;

public record SpaceCultureResponse(
    String address,
    String operationTime,
    List<ArticleDto> articleList
) {
    public static SpaceCultureResponse from(SpaceEntity entity) {
        List<ArticleDto> articleList = entity.getArticleList()
            .stream()
            .map(ArticleDto::from)
            .toList();
        return new SpaceCultureResponse(
            entity.getAddress(),
            entity.getOperationTime(),
            articleList
        );
    }
}
