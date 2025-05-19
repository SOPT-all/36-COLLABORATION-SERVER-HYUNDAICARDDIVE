package org.sopt.hyundai.card.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CardEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = CardTableConstants.COLUMN_TITLE)
    private String title;

    @Column(name = CardTableConstants.COLUMN_CATEGORY)
    private String category;

    @Column(name = CardTableConstants.COLUMN_HASHTAG)
    private String hashTag;

    @Column(name = CardTableConstants.COLUMN_IMAGE_URL)
    private String imageUrl;

    @Column(name = CardTableConstants.COLUMN_LIKES)
    private Long likes;

    private LocalDateTime createdAt;

    @Builder
    public CardEntity(String title, String category, String hashTag, String imageUrl, Long likes, LocalDateTime createdAt) {
        this.title = title;
        this.category = category;
        this.hashTag = hashTag;
        this.imageUrl = imageUrl;
        this.likes = likes;
        this.createdAt = createdAt;
    }
}