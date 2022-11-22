package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.dto.CarCompanyDTO;
import com.smartentry.backend.domain.dto.GateValidationDTO;
import com.smartentry.backend.services.CarCompanyService;
import com.smartentry.backend.services.GateValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/gatevalidation")
@CrossOrigin("*")
public class GateValidationController {

    @Autowired
    private GateValidationService service;

    @GetMapping
    public ResponseEntity<List<GateValidationDTO>> findAll() {
        List<GateValidationDTO> listDto = service.findAll().stream().map(obj -> new GateValidationDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<CarCompany> findById(@PathVariable Integer id) {
//        CarCompany obj = service.findById(id);
//        return ResponseEntity.ok().body(obj);
//    }
//
//    @PostMapping
//    public ResponseEntity<CarCompanyDTO> insert(@RequestBody CarCompanyDTO obj) {
//        obj = new CarCompanyDTO(service.insert(obj));
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
////    @PostMapping
////    public ResponseEntity<Void> insert(@RequestBody CarCompany obj) {
////        obj = service.insert(obj);
////        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
////                .path("/{id}").buildAndExpand(obj.getId()).toUri();
////        return ResponseEntity.created(uri).build();
////    }
}
