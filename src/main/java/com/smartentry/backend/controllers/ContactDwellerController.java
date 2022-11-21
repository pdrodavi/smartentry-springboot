package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.ContactDweller;
import com.smartentry.backend.domain.dto.ContactDwellerDTO;
import com.smartentry.backend.domain.dto.ResidenceDTO;
import com.smartentry.backend.services.ContactDwellerService;
import com.smartentry.backend.services.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/contact")
@CrossOrigin(origins = "https://smartentry-angular.vercel.app")
public class ContactDwellerController {

    @Autowired
    private ContactDwellerService service;

    @GetMapping
    public ResponseEntity<List<ContactDwellerDTO>> findAll() {
        List<ContactDwellerDTO> listDto = service.findAll().stream().map(obj -> new ContactDwellerDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContactDwellerDTO> findById(@PathVariable Integer id) {
        ContactDwellerDTO obj = new ContactDwellerDTO(service.findById(id));
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
