package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.CarVisitant;
import com.smartentry.backend.domain.GateValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateValidationRepository extends JpaRepository<GateValidation, Integer> {
}
