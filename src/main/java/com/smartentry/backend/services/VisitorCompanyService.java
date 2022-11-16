package com.smartentry.backend.services;

import com.smartentry.backend.domain.*;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.VisitorCompanyDTO;
import com.smartentry.backend.repositories.CarCompanyRepository;
import com.smartentry.backend.repositories.VisitorCompanyRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorCompanyService {

    @Autowired
    private VisitorCompanyRepository repository;

    @Autowired
    private CarCompanyService service;

    public List<VisitorCompany> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public VisitorCompany findById(Integer id) {
        VisitorCompany result = repository.findById(id).get();
        Optional<VisitorCompany> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto nao encontrado! " + VisitorCompany.class.getName()));
    }

    public VisitorCompany insert(VisitorCompanyDTO obj) {
        return fromDto(obj);
    }

    private VisitorCompany fromDto(VisitorCompanyDTO obj) {
        VisitorCompany newObj = new VisitorCompany();
        newObj.setId(obj.getId());
        newObj.setFuncionario(obj.getFuncionario());
        newObj.setNome_empresa(obj.getNome_empresa());

        CarCompany carCompany = service.findById(obj.getCarCompany());

        newObj.setCarCompany(carCompany);

        return repository.save(newObj);

    }

    public VisitorCompany update(Integer id, VisitorCompanyDTO obj) {
        VisitorCompany newObj = findById(id);
        newObj.setId(obj.getId());
        newObj.setFuncionario(obj.getFuncionario());
        newObj.setNome_empresa(obj.getNome_empresa());

        CarCompany carCompany = service.findById(obj.getCarCompany());

        newObj.setCarCompany(carCompany);

        return repository.save(newObj);

    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
