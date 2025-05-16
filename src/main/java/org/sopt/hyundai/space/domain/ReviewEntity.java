package org.sopt.hyundai.space.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private SpaceEntity space;

    private String imageUrl;
    private String reviewer;
    private Integer likeCount;

    protected ReviewEntity() {}

    public ReviewEntity(SpaceEntity space, String imageUrl, String reviewer, Integer likeCount) {
        this.space = space;
        this.imageUrl = imageUrl;
        this.reviewer = reviewer;
        this.likeCount = likeCount;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public SpaceEntity getSpace() {
        return space;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getReviewer() {
        return reviewer;
    }

    public Integer getLikeCount() {
        return likeCount;
    }
}
