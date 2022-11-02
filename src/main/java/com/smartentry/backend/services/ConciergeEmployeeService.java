package com.smartentry.backend.services;

import com.smartentry.backend.domain.ConciergeEmployee;
import com.smartentry.backend.domain.Dweller;
import com.smartentry.backend.repositories.ConciergeEmployeeRepository;
import com.smartentry.backend.repositories.DwellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ConciergeEmployeeService {

    @Autowired
    private ConciergeEmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<ConciergeEmployee> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public ConciergeEmployee findById(Integer id) {
        Optional<ConciergeEmployee> result = repository.findById(id);
        return result.orElseThrow();
    }
}
