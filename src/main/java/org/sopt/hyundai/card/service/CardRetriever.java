package org.sopt.hyundai.card.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.domain.Card;
import org.sopt.hyundai.card.repository.CardRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CardRetriever {

    private final CardRepository cardRepository;

    public List<Card> findByCategoryOrderByLikesDesc(String category) {
        return cardRepository.findByCategoryOrderByLikesDesc(category);
    }

    public List<Card> findByCategoryOrderByCreatedAtDesc(String category) {
        return cardRepository.findByCategoryOrderByCreatedAtDesc(category);
    }

    public List<Card> findAllByOrderByLikesDesc() {
        return cardRepository.findAllByOrderByLikesDesc();
    }

    public List<Card> findAllByOrderByCreatedAtDesc() {
        return cardRepository.findAllByOrderByCreatedAtDesc();
    }
}