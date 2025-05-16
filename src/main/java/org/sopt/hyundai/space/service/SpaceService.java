package org.sopt.hyundai.space.service;

import org.sopt.hyundai.common.code.ErrorCode;
import org.sopt.hyundai.space.domain.SpaceEntity;
import org.sopt.hyundai.space.dto.SpaceCultureResponse;
import org.sopt.hyundai.space.dto.SpaceDetailResponse;
import org.sopt.hyundai.space.repository.SpaceRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SpaceService {
    private final SpaceRepository spaceRepository;

    public SpaceService(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    public SpaceCultureResponse getSpaceCulture() {
        SpaceEntity space = spaceRepository.findFirstWithArticlesByOrderByIdAsc()
                .orElseThrow(() -> new NoSuchElementException(ErrorCode.NOT_FOUND_RESOURCE.getMessage()));
        return SpaceCultureResponse.from(space);
    }

    public SpaceDetailResponse getSpaceDetail() {
        SpaceEntity space = spaceRepository.findFirstWithReviewsByOrderByIdAsc()
                .orElseThrow(() -> new NoSuchElementException(ErrorCode.NOT_FOUND_RESOURCE.getMessage()));
        return SpaceDetailResponse.from(space);
    }
}
