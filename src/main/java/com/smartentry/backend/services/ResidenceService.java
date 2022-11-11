package com.smartentry.backend.services;

import com.smartentry.backend.domain.ConciergeEmployee;
import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.Dweller;
import com.smartentry.backend.domain.Residence;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.repositories.CorrespondenceRepository;
import com.smartentry.backend.repositories.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ResidenceService {

    @Autowired
    private ResidenceRepository repository;


    @Transactional(readOnly = true)
    public List<Residence> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Residence findById(Integer id) {
        Optional<Residence> result = repository.findById(id);
        return result.orElseThrow();
    }

//    @Transactional(readOnly = true)
//    public CorrespondenceDTO findById(Integer id) {
//        Correspondence result = repository.findById(id).get();
//        CorrespondenceDTO dto = new CorrespondenceDTO(result);
//        return dto;
//    }
}
