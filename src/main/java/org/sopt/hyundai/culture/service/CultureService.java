package org.sopt.hyundai.culture.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.culture.domain.Culture;
import org.sopt.hyundai.culture.dto.CultureListResponse;
import org.sopt.hyundai.culture.dto.CultureResponse;
import org.sopt.hyundai.culture.repository.CultureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CultureService {

    private final CultureFinder cultureFinder;

    @Transactional
    public CultureListResponse getCulture(){
        List<CultureResponse> cultureResponseList = cultureFinder.findCultureList()
                .stream().map(Culture::fromEntity) // Entity → Domain
                .map(CultureResponse::from).toList(); // Domain → DTO

        return CultureListResponse.from(cultureResponseList);
    }
}
