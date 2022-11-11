package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.ContactDweller;
import com.smartentry.backend.domain.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDwellerRepository extends JpaRepository<ContactDweller, Integer> {
}
