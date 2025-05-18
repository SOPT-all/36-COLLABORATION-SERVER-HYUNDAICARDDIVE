package org.sopt.hyundai.culture.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.culture.domain.CultureEntity;
import org.sopt.hyundai.culture.repository.CultureRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CultureFinder {
    private final CultureRepository cultureRepository;

    public List<CultureEntity> findCultureList(){
        return cultureRepository.findAll();
    }
}
