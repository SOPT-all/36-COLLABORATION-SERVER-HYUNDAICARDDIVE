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

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public String getBanner() {
        return banner;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public List<ArticleEntity> getArticleList() {
        return articleList;
    }

    public List<ReviewEntity> getReviewList() {
        return reviewList;
    }
}
