package com.smartentry.backend.services;

import com.smartentry.backend.domain.*;
import com.smartentry.backend.domain.dto.CarCompanyDTO;
import com.smartentry.backend.domain.dto.CorrespondenceDTO;
import com.smartentry.backend.domain.dto.UserDTO;
import com.smartentry.backend.repositories.CarCompanyRepository;
import com.smartentry.backend.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private DwellerService dwellerService;

    @Autowired
    private UserRepository repository;
//
//    public User execute(User user) {
//
//        User existsUser = repository.findByNome_usuario(user.getNome_usuario());
//
//        if (existsUser != null) {
//            throw new Error("User already exists!");
//        }
//
//        User createdUser = repository.save(user);
//
//        return createdUser;
//    }

    @Transactional(readOnly = true)
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto nao encontrado! " + Correspondence.class.getName()));
    }
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    public User insert(UserDTO obj) {
        return fromDto(obj);
    }

    private User fromDto(UserDTO obj) {
        User newObj = new User();
        newObj.setId(obj.getId());
        newObj.setNomeUsuario(obj.getNomeUsuario());
        newObj.setSenha(obj.getSenha());
        newObj.setStatus(obj.getStatus());


        return repository.save(newObj);

    }

}
