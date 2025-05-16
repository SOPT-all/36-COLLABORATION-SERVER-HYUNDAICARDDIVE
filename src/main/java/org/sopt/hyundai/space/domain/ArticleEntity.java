package org.sopt.hyundai.space.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private SpaceEntity space;

    private String imageUrl;
    private String title;
    private String subTitle;
    private String date;
}
