package org.sopt.hyundai.space.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.code.ErrorCode;
import org.sopt.hyundai.space.domain.SpaceEntity;
import org.sopt.hyundai.space.repository.SpaceRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class SpaceFinder {
    private final SpaceRepository spaceRepository;

    public SpaceEntity findFirstWithArticles() {
        return spaceRepository.findFirstWithArticlesByOrderByIdAsc()
                .orElseThrow(() -> new NoSuchElementException(ErrorCode.NOT_FOUND_RESOURCE.getMessage()));
    }

    public SpaceEntity findFirstWithReviews() {
        return spaceRepository.findFirstWithReviewsByOrderByIdAsc()
                .orElseThrow(() -> new NoSuchElementException(ErrorCode.NOT_FOUND_RESOURCE.getMessage()));
    }
}
