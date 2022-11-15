package com.smartentry.backend.services;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.CarVisitant;
import com.smartentry.backend.domain.dto.CarCompanyDTO;
import com.smartentry.backend.domain.dto.CarVisitantDTO;
import com.smartentry.backend.repositories.CarCompanyRepository;
import com.smartentry.backend.repositories.CarVisitantRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarVisitantService {

    @Autowired
    private CarVisitantRepository repository;

    public List<CarVisitant> findAll() {
        return repository.findAll();
    }

    public CarVisitant insert(CarVisitantDTO obj) {
        return fromDto(obj);
    }

    private CarVisitant fromDto(CarVisitantDTO obj) {
        CarVisitant newObj = new CarVisitant();
        newObj.setId(obj.getId());
        newObj.setPlaca(obj.getPlaca());
        newObj.setStatus(obj.getStatus());

        return repository.save(newObj);

    }

    @Transactional(readOnly = true)
    public CarVisitant findById(Integer id) {
        Optional<CarVisitant> obj = repository.findById(id);
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
