package com.smartentry.backend.services;

import com.smartentry.backend.domain.*;
import com.smartentry.backend.domain.dto.VisitantDTO;
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

    @Autowired
    private DwellerService dwellerService;

    @Autowired
    private CarVisitantService carVisitantService;

    public List<Visitant> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Visitant findById(Integer id) {
        Optional<Visitant> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto nao encontrado! " + Visitant.class.getName()));
    }

    public Visitant insert(VisitantDTO obj) {
        return fromDto(obj);
    }

    private Visitant fromDto(VisitantDTO obj) {
        Visitant newObj = new Visitant();
        newObj.setId(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setStatus(obj.getStatus());
        newObj.setCpf(obj.getCpf());
        newObj.setTipo(obj.getTipo());

        Dweller dweller = dwellerService.findById(obj.getDweller());

        CarVisitant carVisitant = carVisitantService.findById(obj.getVCar());

        newObj.setDweller(dweller);
        newObj.setCarVisitant(carVisitant);

        return repository.save(newObj);

    }

    public Visitant update(Visitant obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
