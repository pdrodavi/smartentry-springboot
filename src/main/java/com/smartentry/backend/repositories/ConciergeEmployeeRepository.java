package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.ConciergeEmployee;
import com.smartentry.backend.domain.Dweller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConciergeEmployeeRepository extends JpaRepository<ConciergeEmployee, Integer> {

}
