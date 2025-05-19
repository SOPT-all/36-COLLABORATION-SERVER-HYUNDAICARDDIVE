package org.sopt.hyundai.card.repository;

import org.sopt.hyundai.card.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByCategoryOrderByLikesDesc(String category);
    List<Card> findByCategoryOrderByCreatedAtDesc(String category);

    List<Card> findAllByOrderByLikesDesc();
    List<Card> findAllByOrderByCreatedAtDesc();
}