package com.smartentry.backend.services;

import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.Dweller;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.repositories.CorrespondenceRepository;
import com.smartentry.backend.repositories.DwellerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class DwellerService {

    @Autowired
    private DwellerRepository repository;

    @Transactional(readOnly = true)
    public List<Dweller> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Dweller findById(Integer id) {
        Optional<Dweller> result = repository.findById(id);
        return result.orElseThrow();
    }
}
