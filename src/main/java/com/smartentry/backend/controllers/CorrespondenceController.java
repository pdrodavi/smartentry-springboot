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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/correspondences")
public class CorrespondenceController {

    @Autowired
    private CorrespondenceService service;

    @GetMapping
    public ResponseEntity<List<CorrespondenceDTO>> findAll() {
        List<CorrespondenceDTO> listDto = service.findAll().stream().map(obj -> new CorrespondenceDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CorrespondenceDTO> findById(@PathVariable Integer id) {
        CorrespondenceDTO obj = new CorrespondenceDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

//    @GetMapping
//    public List<Correspondence> findAll() {
//        return service.findAll();
//    }

    @PostMapping
    public ResponseEntity<CorrespondenceDTO> insert(@RequestBody CorrespondenceDTO obj) {
        obj = new CorrespondenceDTO(service.insert(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CorrespondenceDTO> update(@PathVariable Integer id, @RequestBody CorrespondenceDTO obj) {
        Correspondence newObj = service.update(id, obj);
        return ResponseEntity.ok().body(new CorrespondenceDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
