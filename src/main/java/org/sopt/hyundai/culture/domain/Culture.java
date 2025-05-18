package org.sopt.hyundai.culture.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.culture.domain.enums.Stage;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class Culture {
    private final Long id;
    private final LocalDate date;
    private final String title;
    private final String description;
    private final Stage stage;
    private final String location;
    private final boolean reservation;
    private final String image;

    public static Culture fromEntity(CultureEntity cultureEntity){
        return new Culture(cultureEntity.getId(),
                cultureEntity.getDate(),
                cultureEntity.getTitle(),
                cultureEntity.getDescription(),
                cultureEntity.getStage(),
                cultureEntity.getLocation(),
                cultureEntity.isReservation(),
                cultureEntity.getImage());
    }
}
