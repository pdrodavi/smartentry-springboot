package com.smartentry.backend.services;

import com.smartentry.backend.domain.ContactDweller;
import com.smartentry.backend.domain.Residence;
import com.smartentry.backend.repositories.ContactDwellerRepository;
import com.smartentry.backend.repositories.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ContactDwellerService {

    @Autowired
    private ContactDwellerRepository repository;


    @Transactional(readOnly = true)
    public List<ContactDweller> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public ContactDweller findById(Integer id) {
        Optional<ContactDweller> result = repository.findById(id);
        return result.orElseThrow();
    }

//    @Transactional(readOnly = true)
//    public CorrespondenceDTO findById(Integer id) {
//        Correspondence result = repository.findById(id).get();
//        CorrespondenceDTO dto = new CorrespondenceDTO(result);
//        return dto;
//    }
}
