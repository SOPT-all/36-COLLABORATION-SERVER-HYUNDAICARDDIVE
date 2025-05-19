package org.sopt.hyundai.space.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.space.dto.SpaceCultureResponse;
import org.sopt.hyundai.space.dto.SpaceDetailResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceService {
    private final SpaceFinder spaceFinder;

    public SpaceCultureResponse getSpaceCulture() {
        return SpaceCultureResponse.from(spaceFinder.findFirstWithArticles());
    }

    public SpaceDetailResponse getSpaceDetail() {
        return SpaceDetailResponse.from(spaceFinder.findFirstWithReviews());
    }
}
