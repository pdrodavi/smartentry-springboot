package com.smartentry.backend.services;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.VisitorCompany;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.VisitorCompanyDTO;
import com.smartentry.backend.repositories.CarCompanyRepository;
import com.smartentry.backend.repositories.VisitorCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitorCompanyService {

    @Autowired
    private VisitorCompanyRepository repository;

    public List<VisitorCompany> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public VisitorCompanyDTO findById(Integer id) {
        VisitorCompany result = repository.findById(id).get();
        VisitorCompanyDTO dto = new VisitorCompanyDTO(result);
        return dto;
    }
}
