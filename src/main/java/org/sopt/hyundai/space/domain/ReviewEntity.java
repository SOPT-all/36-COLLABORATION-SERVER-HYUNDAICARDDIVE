package org.sopt.hyundai.space.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SpaceEntity space;

    private String imageUrl;
    private String reviewer;
    private Integer likeCount;
}
