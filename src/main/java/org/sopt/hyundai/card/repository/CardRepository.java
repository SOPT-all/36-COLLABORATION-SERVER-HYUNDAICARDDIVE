package org.sopt.hyundai.card.repository;

import org.sopt.hyundai.card.domain.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

    List<CardEntity> findByCategoryOrderByLikesDesc(String category);
    List<CardEntity> findByCategoryOrderByCreatedAtDesc(String category);

    List<CardEntity> findAllByOrderByLikesDesc();
    List<CardEntity> findAllByOrderByCreatedAtDesc();
}