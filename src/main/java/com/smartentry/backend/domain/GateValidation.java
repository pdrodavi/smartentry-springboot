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
@Table(name = "validacao_portao")
public class GateValidation implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_carro_visitante")
    private CarVisitant carVisitant;


    @OneToOne
    @JoinColumn(name = "id_carro_empresa")
    private CarCompany carCompany;

    private String liberacao;
}
