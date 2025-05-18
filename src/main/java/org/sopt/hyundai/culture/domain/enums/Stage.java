package org.sopt.hyundai.culture.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Stage {
    STORAGE("스토리지"), UNDERSTAGE("언더스테이지");

    private final String korean;
}
