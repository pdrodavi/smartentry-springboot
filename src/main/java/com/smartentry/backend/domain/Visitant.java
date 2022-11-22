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
@Table(name = "visitante")
public class Visitant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cpf;

    private Integer tipo;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_morador")
    private Dweller dweller;

    @ManyToOne
    @JoinColumn(name = "id_vcarro")
    private CarVisitant carVisitant;
}
