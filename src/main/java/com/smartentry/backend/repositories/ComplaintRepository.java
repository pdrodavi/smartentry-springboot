package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
}
