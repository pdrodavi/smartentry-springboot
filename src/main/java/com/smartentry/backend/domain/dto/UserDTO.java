package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;

    private String nomeUsuario;

    private Integer status;


    public UserDTO(User user) {
        id = user.getId();
        nomeUsuario = user.getNomeUsuario();
        status = user.getStatus();
    }

}
