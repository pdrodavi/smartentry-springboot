package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.Car;
import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.dto.CarCompanyDTO;
import com.smartentry.backend.domain.dto.CarDTO;
import com.smartentry.backend.services.CarCompanyService;
import com.smartentry.backend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/car")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping
    public ResponseEntity<List<CarDTO>> findAll() {
        List<CarDTO> listDto = service.findAll().stream().map(obj -> new CarDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Car> findById(@PathVariable Integer id) {
        Car obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<CarDTO> insert(@RequestBody CarDTO obj) {
        obj = new CarDTO(service.insert(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody CarCompany obj) {
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
}
