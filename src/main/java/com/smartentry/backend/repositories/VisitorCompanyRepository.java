package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.Visitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorCompanyRepository extends JpaRepository<CarCompany, Integer> {
}
