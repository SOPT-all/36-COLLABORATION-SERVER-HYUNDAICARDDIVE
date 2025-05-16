package org.sopt.hyundai.space.service;

import org.sopt.hyundai.space.domain.SpaceEntity;
import org.sopt.hyundai.space.dto.SpaceCultureResponse;
import org.sopt.hyundai.space.dto.SpaceDetailResponse;
import org.sopt.hyundai.space.repository.SpaceRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SpaceService {
    private static final Long SPACE_ID = 1L;

    private final SpaceRepository spaceRepository;

    public SpaceService(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    public SpaceCultureResponse getSpaceCulture() {
        SpaceEntity space = spaceRepository.findWithArticlesById(SPACE_ID)
                .orElseThrow(() -> new NoSuchElementException("해당 공간이 존재하지 않습니다."));
        return SpaceCultureResponse.from(space);
    }

    public SpaceDetailResponse getSpaceDetail() {
        SpaceEntity space = spaceRepository.findWithReviewsById(SPACE_ID)
                .orElseThrow(() -> new NoSuchElementException("해당 공간이 존재하지 않습니다."));
        return SpaceDetailResponse.from(space);
    }
}
