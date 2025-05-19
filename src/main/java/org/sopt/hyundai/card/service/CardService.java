package org.sopt.hyundai.card.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.controller.dto.CardRes;
import org.sopt.hyundai.card.domain.CardEntity;
import org.sopt.hyundai.common.code.ErrorCode;
import org.sopt.hyundai.exception.InvalidCategoryException;
import org.sopt.hyundai.exception.InvalidSortOptionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRetriever cardRetriever;

    public CardRes getHome(final String sortOption, final String category) {
        String cardSort = (sortOption == null || sortOption.isBlank()) ? "recommended" : sortOption;
        String cardCategory = (category == null || category.isBlank()) ? "total" : category;

        if (!CardCategory.isValid(cardCategory)) {
            throw new InvalidCategoryException(ErrorCode.INVALID_CATEGORY);
        }

        List<CardEntity> cards = switch (cardSort) {
            case "recommended" -> getRecommendedCards(cardCategory);
            case "latest" -> getLatestCards(cardCategory);
            default -> throw new InvalidSortOptionException(ErrorCode.INVALID_SORT_OPTION);
        };

        List<CardRes.CardDto> cardDtoList = cards.stream()
                .map(card -> CardRes.CardDto.builder()
                        .title(card.getTitle())
                        .category(card.getCategory())
                        .hashTag(card.getHashTag())
                        .imageUrl(card.getImageUrl())
                        .build()
                )
                .toList();

        return new CardRes(cardDtoList);
    }

    private List<CardEntity> getRecommendedCards(String category) {
        return category.equals("total")
                ? cardRetriever.findAllByOrderByLikesDesc()
                : cardRetriever.findByCategoryOrderByLikesDesc(category);
    }

    private List<CardEntity> getLatestCards(String category) {
        return category.equals("total")
                ? cardRetriever.findAllByOrderByCreatedAtDesc()
                : cardRetriever.findByCategoryOrderByCreatedAtDesc(category);
    }
}