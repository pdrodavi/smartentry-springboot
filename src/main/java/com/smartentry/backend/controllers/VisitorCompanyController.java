package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.VisitorCompany;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.VisitorCompanyDTO;
import com.smartentry.backend.services.CarCompanyService;
import com.smartentry.backend.services.VisitorCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
