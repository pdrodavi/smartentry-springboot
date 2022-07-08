package com.smartentry.backend.services;

import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.repositories.CorrespondenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CorrespondenceService {

    @Autowired
    private CorrespondenceRepository repository;

    @Transactional(readOnly = true)
    public Page<CorrespondenceDTO> findAll(Pageable pageable) {
        Page<Correspondence> result = repository.findAll(pageable);
        Page<CorrespondenceDTO> page = result.map(x -> new CorrespondenceDTO(x));
        return page;
    }

//    public List<Correspondence> findAll() {
//        return repository.findAll();
//    }

    public Correspondence insert(Correspondence obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Correspondence update(Correspondence obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
