package org.sopt.hyundai.card.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.domain.CardEntity;
import org.sopt.hyundai.card.repository.CardRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CardRetriever {

    private final CardRepository cardRepository;

    public List<CardEntity> findByCategoryOrderByLikesDesc(String category) {
        return cardRepository.findByCategoryOrderByLikesDesc(category);
    }

    public List<CardEntity> findByCategoryOrderByCreatedAtDesc(String category) {
        return cardRepository.findByCategoryOrderByCreatedAtDesc(category);
    }

    public List<CardEntity> findAllByOrderByLikesDesc() {
        return cardRepository.findAllByOrderByLikesDesc();
    }

    public List<CardEntity> findAllByOrderByCreatedAtDesc() {
        return cardRepository.findAllByOrderByCreatedAtDesc();
    }
}