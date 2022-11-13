package com.smartentry.backend.services;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.CarVisitant;
import com.smartentry.backend.domain.VisitorCompany;
import com.smartentry.backend.domain.dto.CarCompanyDTO;
import com.smartentry.backend.domain.dto.VisitorCompanyDTO;
import com.smartentry.backend.repositories.CarCompanyRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarCompanyService {

    @Autowired
    private CarCompanyRepository repository;

    public List<CarCompany> findAll() {
        return repository.findAll();
    }

    public CarCompany insert(CarCompanyDTO obj) {
        return fromDto(obj);
    }

    private CarCompany fromDto(CarCompanyDTO obj) {
        CarCompany newObj = new CarCompany();
        newObj.setId(obj.getId());
        newObj.setPlaca(obj.getPlaca());
        newObj.setStatus(obj.getStatus());

        return repository.save(newObj);

    }

    @Transactional(readOnly = true)
    public CarCompany findById(Integer id) {
        Optional<CarCompany> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto nao encontrado! " + CarCompany.class.getName()));
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
