package com.smartentry.backend.services;

import com.smartentry.backend.domain.CarVisitant;
import com.smartentry.backend.domain.Visitant;
import com.smartentry.backend.repositories.VisitantRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VisitantService {

    @Autowired
    private VisitantRepository repository;

    public List<CarVisitant> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public CarVisitant findById(Integer id) {
        Optional<CarVisitant> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto nao encontrado! " + CarVisitant.class.getName()));
    }

    public CarVisitant insert(CarVisitant obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public CarVisitant update(CarVisitant obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
