package com.smartentry.backend.services;

import com.smartentry.backend.domain.Role;
import com.smartentry.backend.domain.User;
import com.smartentry.backend.domain.dto.CreateUserRoleDTO;
import com.smartentry.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateRoleUserService {

//    @Autowired
//    UserRepository userRepository;
//
//    public User execute(CreateUserRoleDTO createUserRoleDTO) {
//        Optional<User> userExists = userRepository.findById(createUserRoleDTO.getId());
//        List<Role> roles = new ArrayList<>();
//
//        if (userExists.isEmpty()) {
//            throw new Error("User does not exists!");
//        }
//
//        roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
//            return new Role(role);
//        }).collect(Collectors.toList());
//
//        User user = userExists.get();
//
//        user.setRoles(roles);
//
//        userRepository.save(user);
//
//        return user;
//    }
}
