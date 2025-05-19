package org.sopt.hyundai.culture.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.hyundai.culture.domain.enums.Stage;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CultureEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Column
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private Stage stage;

    @Column
    private String location;

    @Column
    private boolean reservation;

    @Column
    private String image;

}