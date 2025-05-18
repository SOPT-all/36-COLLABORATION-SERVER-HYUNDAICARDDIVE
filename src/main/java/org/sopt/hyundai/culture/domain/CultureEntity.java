package org.sopt.hyundai.culture.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.sopt.hyundai.culture.domain.enums.Stage;

import java.time.LocalDate;

@Entity
@Getter
public class CultureEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

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