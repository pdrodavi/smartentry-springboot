package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.DwellerDTO;
import com.smartentry.backend.services.DwellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/dweller")
@CrossOrigin(origins = "https://smartentry-angular.vercel.app")
public class DwellerController {

    @Autowired
    private DwellerService service;

    @GetMapping
    public ResponseEntity<List<DwellerDTO>> findAll() {
        List<DwellerDTO> listDto = service.findAll().stream().map(obj -> new DwellerDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DwellerDTO> findById(@PathVariable Integer id) {
        DwellerDTO obj = new DwellerDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<DwellerDTO> insert(@RequestBody DwellerDTO obj) {
        obj = new DwellerDTO(service.insert(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
