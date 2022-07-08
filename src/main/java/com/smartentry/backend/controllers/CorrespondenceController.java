package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.services.CorrespondenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/correspondences")
public class CorrespondenceController {

    @Autowired
    private CorrespondenceService service;

    @GetMapping
    public Page<CorrespondenceDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

//    @GetMapping
//    public List<Correspondence> findAll() {
//        return service.findAll();
//    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Correspondence obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Correspondence obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
