package com.smartentry.backend.domain;

import com.smartentry.backend.domain.enums.Perfil;
import lombok.*;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "nome_usuario")
    private String nomeUsuario;

    private String senha;

    private Integer status;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "perfis")
//    private Set<Integer> perfis = new HashSet<>();
//
//    public Set<Perfil> getPerfis() {
//        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
//    }
//
//    public void addPerfil(Perfil perfil) {
//        perfis.add(perfil.getCod());
//    }

}
