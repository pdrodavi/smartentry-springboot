package com.smartentry.backend.services;

import com.smartentry.backend.domain.*;
import com.smartentry.backend.repositories.RoleRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Transactional(readOnly = true)
    public Role findById(Integer id) {
        Optional<Role> obj = roleRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto nao encontrado! " + Role.class.getName()));
    }

}
