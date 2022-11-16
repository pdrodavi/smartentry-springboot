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
@Table(name = "visit_empresa")
public class VisitorCompany implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome_empresa;

    private String funcionario;

    @OneToOne
    @JoinColumn(name = "id_ecarro")
    private CarCompany carCompany;

}
