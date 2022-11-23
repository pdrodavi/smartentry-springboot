package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.ConciergeEmployee;
import com.smartentry.backend.domain.Dweller;
import com.smartentry.backend.domain.dto.ConciergeEmployeeDTO;
import com.smartentry.backend.domain.dto.DwellerDTO;
import com.smartentry.backend.domain.dto.VisitorCompanyDTO;
import com.smartentry.backend.services.ConciergeEmployeeService;
import com.smartentry.backend.services.DwellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/concierge")
@CrossOrigin("*")
public class ConciergeEmployeeController {

    @Autowired
    private ConciergeEmployeeService service;

    @GetMapping
    public ResponseEntity<List<ConciergeEmployeeDTO>> findAll() {
        List<ConciergeEmployeeDTO> listDto = service.findAll().stream().map(obj -> new ConciergeEmployeeDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConciergeEmployeeDTO> findById(@PathVariable Integer id) {
        ConciergeEmployeeDTO obj = new ConciergeEmployeeDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ConciergeEmployeeDTO> insert(@RequestBody ConciergeEmployeeDTO obj) {
        obj = new ConciergeEmployeeDTO(service.insert(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConciergeEmployeeDTO> update(@PathVariable Integer id, @RequestBody ConciergeEmployeeDTO obj) {
        ConciergeEmployee newObj = service.update(id, obj);
        return ResponseEntity.ok().body(new ConciergeEmployeeDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
