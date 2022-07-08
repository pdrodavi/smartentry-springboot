package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.Correspondence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrespondenceRepository extends JpaRepository<Correspondence, Integer> {

}
