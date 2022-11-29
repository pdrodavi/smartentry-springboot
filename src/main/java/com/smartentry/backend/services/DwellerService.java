package com.smartentry.backend.services;

import com.smartentry.backend.domain.*;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.DwellerDTO;
import com.smartentry.backend.repositories.CorrespondenceRepository;
import com.smartentry.backend.repositories.DwellerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class DwellerService {

    @Autowired
    private DwellerRepository repository;

    @Autowired
    private ResidenceService dwellerService;

    @Autowired
    private ContactDwellerService contactDwellerService;

    @Autowired
    private CarService carService;

    @Transactional(readOnly = true)
    public List<Dweller> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Dweller findById(Integer id) {
        Optional<Dweller> result = repository.findById(id);
        return result.orElseThrow();
    }

    public Dweller insert(DwellerDTO obj) {
        return fromDto(obj);
    }

    private Dweller fromDto(DwellerDTO obj) {
        Dweller newObj = new Dweller();
        newObj.setId(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setCpf(obj.getCpf());
        newObj.setRg(obj.getRg());
        newObj.setStatus(obj.getStatus());

        Residence residence = dwellerService.findById(obj.getResidencia());

        ContactDweller contactDweller = contactDwellerService.findById(obj.getContactDweller());

        Car car = carService.findById(obj.getCarro());

        newObj.setResidence(residence);
        newObj.setContactDweller(contactDweller);
        newObj.setCar(car);

        return repository.save(newObj);

    }

    public Dweller update(Integer id, DwellerDTO obj) {
        Dweller newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setRg(obj.getRg());
        newObj.setCpf(obj.getCpf());
        newObj.setStatus(obj.getStatus());


        Residence residence = dwellerService.findById(obj.getResidencia());

        ContactDweller contactDweller = contactDwellerService.findById(obj.getContactDweller());

        Car car = carService.findById(obj.getCarro());

        newObj.setResidence(residence);
        newObj.setContactDweller(contactDweller);
        newObj.setCar(car);

        return repository.save(newObj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
