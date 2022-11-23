package com.smartentry.backend.services;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.ConciergeEmployee;
import com.smartentry.backend.domain.Dweller;
import com.smartentry.backend.domain.VisitorCompany;
import com.smartentry.backend.domain.dto.ConciergeEmployeeDTO;
import com.smartentry.backend.domain.dto.VisitorCompanyDTO;
import com.smartentry.backend.repositories.ConciergeEmployeeRepository;
import com.smartentry.backend.repositories.DwellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ConciergeEmployeeService {

    @Autowired
    private ConciergeEmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<ConciergeEmployee> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public ConciergeEmployee findById(Integer id) {
        Optional<ConciergeEmployee> result = repository.findById(id);
        return result.orElseThrow();
    }

    public ConciergeEmployee insert(ConciergeEmployeeDTO obj) {
        return fromDto(obj);
    }

    private ConciergeEmployee fromDto(ConciergeEmployeeDTO obj) {
        ConciergeEmployee newObj = new ConciergeEmployee();
        newObj.setId(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setCpf(obj.getCpf());
        newObj.setStatus(obj.getStatus());
        newObj.setData_admissao(obj.getData_admissao());
        newObj.setData_demissao(obj.getData_demissao());
        newObj.setTurno(obj.getTurno());

        return repository.save(newObj);

    }

    public ConciergeEmployee update(Integer id, ConciergeEmployeeDTO obj) {
        ConciergeEmployee newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setCpf(obj.getCpf());
        newObj.setStatus(obj.getStatus());
        newObj.setData_admissao(obj.getData_admissao());
        newObj.setData_demissao(obj.getData_demissao());
        newObj.setTurno(obj.getTurno());

        return repository.save(newObj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
