package org.sopt.hyundai.culture.repository;

import org.sopt.hyundai.culture.domain.CultureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CultureRepository extends JpaRepository<CultureEntity, Long> {
}
