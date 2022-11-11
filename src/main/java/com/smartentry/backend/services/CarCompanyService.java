package com.smartentry.backend.services;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.repositories.CarCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarCompanyService {

    @Autowired
    private CarCompanyRepository repository;

    public List<CarCompany> findAll() {
        return repository.findAll();
    }

    public CarCompany insert(CarCompany obj) {
        obj.setId(null);
        return repository.save(obj);
    }
//
//    public Visitant update(Visitant obj) {
//        return repository.save(obj);
//    }
//
//    public void delete(Integer id) {
//        repository.deleteById(id);
//    }
}
