package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Integer> {
}
