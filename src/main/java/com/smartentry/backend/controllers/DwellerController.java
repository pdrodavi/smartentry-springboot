package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.Dweller;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.DwellerDTO;
import com.smartentry.backend.services.DwellerService;
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
@RequestMapping(value = "/api/dweller")
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
}
