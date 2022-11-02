package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.dto.ConciergeEmployeeDTO;
import com.smartentry.backend.domain.dto.DwellerDTO;
import com.smartentry.backend.services.ConciergeEmployeeService;
import com.smartentry.backend.services.DwellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/concierge")
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
}
