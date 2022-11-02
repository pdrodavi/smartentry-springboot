package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.Dweller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwellerRepository extends JpaRepository<Dweller, Integer> {

}
