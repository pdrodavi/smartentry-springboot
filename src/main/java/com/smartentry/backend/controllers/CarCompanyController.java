package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.dto.CarCompanyDTO;
import com.smartentry.backend.services.CarCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/car")
public class CarCompanyController {

    @Autowired
    private CarCompanyService service;

    @GetMapping
    public ResponseEntity<List<CarCompanyDTO>> findAll() {
        List<CarCompanyDTO> listDto = service.findAll().stream().map(obj -> new CarCompanyDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody CarCompany obj) {
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
}
