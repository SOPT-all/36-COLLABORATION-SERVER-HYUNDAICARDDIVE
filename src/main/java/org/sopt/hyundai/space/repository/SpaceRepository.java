package org.sopt.hyundai.space.repository;

import org.sopt.hyundai.space.domain.SpaceEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpaceRepository extends JpaRepository<SpaceEntity, Long> {
    @EntityGraph(attributePaths = "articleList")
    Optional<SpaceEntity> findFirstWithArticlesByOrderByIdAsc();

    @EntityGraph(attributePaths = "reviewList")
    Optional<SpaceEntity> findFirstWithReviewsByOrderByIdAsc();
}
