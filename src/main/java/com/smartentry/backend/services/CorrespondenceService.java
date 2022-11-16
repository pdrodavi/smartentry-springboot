package com.smartentry.backend.services;

import com.smartentry.backend.domain.ConciergeEmployee;
import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.Dweller;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.repositories.ConciergeEmployeeRepository;
import com.smartentry.backend.repositories.CorrespondenceRepository;
import com.smartentry.backend.repositories.DwellerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CorrespondenceService {

    @Autowired
    private CorrespondenceRepository repository;

    @Autowired
    private DwellerService dwellerService;

    @Autowired
    private ConciergeEmployeeService employeeService;


    @Transactional(readOnly = true)
    public List<Correspondence> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Correspondence findById(Integer id) {
        Optional<Correspondence> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto nao encontrado! " + Correspondence.class.getName()));
    }

//    public List<Correspondence> findAll() {
//        return repository.findAll();
//    }

    public Correspondence insert(CorrespondenceDTO obj) {
        return fromDto(obj);
    }

    private Correspondence fromDto(CorrespondenceDTO obj) {
        Correspondence newObj = new Correspondence();
        newObj.setId(obj.getId());
        newObj.setTipo_correspondencia(obj.getTipo_correspondencia());
        newObj.setData_recebimento(obj.getData_recebimento());
        newObj.setStatus_entrega(obj.getStatus_entrega());

        Dweller dweller = dwellerService.findById(obj.getDweller());

        ConciergeEmployee conciergeEmployee = employeeService.findById(obj.getConciergeEmployee());

        newObj.setDweller(dweller);
        newObj.setConciergeEmployee(conciergeEmployee);

        return repository.save(newObj);

    }

    public Correspondence update(Integer id, CorrespondenceDTO obj) {
        Correspondence newObj = findById(id);
        newObj.setTipo_correspondencia(obj.getTipo_correspondencia());
        newObj.setData_recebimento(obj.getData_recebimento());
        newObj.setStatus_entrega(obj.getStatus_entrega());

        Dweller dweller = dwellerService.findById(obj.getDweller());

        ConciergeEmployee conciergeEmployee = employeeService.findById(obj.getConciergeEmployee());

        newObj.setDweller(dweller);
        newObj.setConciergeEmployee(conciergeEmployee);

        return repository.save(newObj);

    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
