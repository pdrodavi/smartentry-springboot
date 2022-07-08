package com.smartentry.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "morador")
public class Dweller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer cpf;

    private String rg;

    private Integer status;


    @OneToOne
    @JoinColumn(name = "id_apto")
    private Residence residence;


    @OneToOne
    @JoinColumn(name = "id_contato_morador")
    private ContactDweller contactDweller;
}
