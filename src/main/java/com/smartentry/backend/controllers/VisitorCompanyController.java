package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.VisitorCompany;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.VisitorCompanyDTO;
import com.smartentry.backend.services.CarCompanyService;
import com.smartentry.backend.services.VisitorCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/company")
public class VisitorCompanyController {

    @Autowired
    private VisitorCompanyService service;

    @GetMapping
    public ResponseEntity<List<VisitorCompanyDTO>> findAll() {
        List<VisitorCompanyDTO> listDto = service.findAll().stream().map(obj -> new VisitorCompanyDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public VisitorCompanyDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<VisitorCompanyDTO> insert(@RequestBody VisitorCompanyDTO obj) {
        obj = new VisitorCompanyDTO(service.insert(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<VisitorCompanyDTO> update(@RequestBody VisitorCompanyDTO obj) {
        obj = new VisitorCompanyDTO(service.update(obj));
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
