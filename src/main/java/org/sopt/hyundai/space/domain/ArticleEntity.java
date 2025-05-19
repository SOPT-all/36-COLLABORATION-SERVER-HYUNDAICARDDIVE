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

    protected ArticleEntity() {}

    public ArticleEntity(SpaceEntity space, String imageUrl, String title, String subTitle, String date) {
        this.space = space;
        this.imageUrl = imageUrl;
        this.title = title;
        this.subTitle = subTitle;
        this.date = date;
    }

    public Long getArticleId() {
        return articleId;
    }

    public SpaceEntity getSpace() {
        return space;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDate() {
        return date;
    }
}
