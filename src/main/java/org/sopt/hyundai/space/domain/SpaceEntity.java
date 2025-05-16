package org.sopt.hyundai.space.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "space")
public class SpaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String operationTime;
    private String banner;

    @Column(columnDefinition = "TEXT")
    private String introduction;

    private String telephone;
    private String email;

    @OneToMany(
        mappedBy = "space",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ArticleEntity> articleList = new ArrayList<>();

    @OneToMany(
        mappedBy = "space",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ReviewEntity> reviewList = new ArrayList<>();
}
