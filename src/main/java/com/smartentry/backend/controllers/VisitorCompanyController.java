package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.services.VisitorCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/visitor/company")
public class VisitorCompanyController {

    @Autowired
    private VisitorCompanyService service;

    @GetMapping
    public List<CarCompany> findAll() {
        return service.findAll();
    }

//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody CarCompany obj) {
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
}
