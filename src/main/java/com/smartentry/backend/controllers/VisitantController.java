package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.Visitant;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.VisitantDTO;
import com.smartentry.backend.services.VisitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/visitants")
@CrossOrigin("*")
public class VisitantController {

    @Autowired
    private VisitantService service;

    @GetMapping
    public ResponseEntity<List<VisitantDTO>> findAll() {
        List<VisitantDTO> listDto = service.findAll().stream().map(obj -> new VisitantDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VisitantDTO> findById(@PathVariable Integer id) {
        VisitantDTO obj = new VisitantDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<VisitantDTO> insert(@RequestBody VisitantDTO obj) {
        obj = new VisitantDTO(service.insert(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VisitantDTO> update(@PathVariable Integer id, @RequestBody VisitantDTO obj) {
        Visitant newObj = service.update(id, obj);
        return ResponseEntity.ok().body(new VisitantDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
