package com.smartentry.backend.services;

import com.smartentry.backend.domain.Visitant;
import com.smartentry.backend.repositories.VisitantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitantService {

    @Autowired
    private VisitantRepository repository;

    public List<Visitant> findAll() {
        return repository.findAll();
    }

    public Visitant insert(Visitant obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Visitant update(Visitant obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
