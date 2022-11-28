package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.Car;
import com.smartentry.backend.domain.Residence;
import com.smartentry.backend.domain.dto.CarDTO;
import com.smartentry.backend.domain.dto.ResidenceDTO;
import com.smartentry.backend.services.CarService;
import com.smartentry.backend.services.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/residence")
@CrossOrigin(origins = "*")
public class ResidenceController {

    @Autowired
    private ResidenceService service;

    @GetMapping
    public ResponseEntity<List<ResidenceDTO>> findAll() {
        List<ResidenceDTO> listDto = service.findAll().stream().map(obj -> new ResidenceDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResidenceDTO> findById(@PathVariable Integer id) {
        ResidenceDTO obj = new ResidenceDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
//    @PostMapping
//    public ResponseEntity<ResidenceDTO> insert(@RequestBody CarDTO obj) {
//        obj = new CarDTO(service.insert(obj));
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody CarCompany obj) {
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
}
