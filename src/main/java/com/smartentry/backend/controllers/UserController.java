package com.smartentry.backend.controllers;

import com.smartentry.backend.domain.User;
import com.smartentry.backend.domain.dto.ComplaintDTO;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.CreateUserRoleDTO;
import com.smartentry.backend.domain.dto.UserDTO;
import com.smartentry.backend.services.CreateRoleUserService;
import com.smartentry.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private CreateRoleUserService createRoleUserService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> listDto = service.findAll().stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        UserDTO obj = new UserDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/")
    public String login() {
        return "sucess";
    }

//    @PostMapping("/role")
//    public User role(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
//        return createRoleUserService.execute(createUserRoleDTO);
//    }
}
