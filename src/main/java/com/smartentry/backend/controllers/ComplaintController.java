package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.dto.ComplaintDTO;
import com.smartentry.backend.services.ComplaintService;
import com.smartentry.backend.services.CorrespondenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService service;

    @GetMapping
    public ResponseEntity<List<ComplaintDTO>> findAll() {
        List<ComplaintDTO> listDto = service.findAll().stream().map(obj -> new ComplaintDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ComplaintDTO> findById(@PathVariable Integer id) {
        ComplaintDTO obj = new ComplaintDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

//    @GetMapping
//    public List<Correspondence> findAll() {
//        return service.findAll();
//    }

    @PostMapping
    public ResponseEntity<ComplaintDTO> insert(@RequestBody ComplaintDTO obj) {
        obj = new ComplaintDTO(service.insert(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<ComplaintDTO> update(@RequestBody ComplaintDTO obj) {
        obj = new ComplaintDTO(service.update(obj));
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
