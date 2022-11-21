package com.smartentry.backend.services;

import com.smartentry.backend.domain.*;
import com.smartentry.backend.domain.dto.ComplaintDTO;
import com.smartentry.backend.repositories.ComplaintRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository repository;

    @Autowired
    private RoleService service;


    @Transactional(readOnly = true)
    public List<Complaint> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Complaint findById(Integer id) {
        Optional<Complaint> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto nao encontrado! " + Complaint.class.getName()));
    }

//    public List<Correspondence> findAll() {
//        return repository.findAll();
//    }

//    public Complaint insert(ComplaintDTO obj) {
//        return fromDto(obj);
//    }


//    private Complaint fromDto(ComplaintDTO obj) {
//        Complaint newObj = new Complaint();
//        newObj.setId(obj.getId());
//        newObj.setData(obj.getData());
//        newObj.setReclamacao(obj.getReclamacao());
//
//        User user = service.findById(obj.getUser());
//
//        newObj.setUser(user);
//
//        return repository.save(newObj);
//
//    }

//    public Complaint update(ComplaintDTO obj) {
//        findById(obj.getId());
//        return fromDto(obj);
//
//    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
