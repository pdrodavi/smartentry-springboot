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
@Table(name = "func_portaria")
public class ConciergeEmployee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer cpf;

    private Integer status;

    private String data_admissao;

    private String data_demissao;

    private String turno;
}
