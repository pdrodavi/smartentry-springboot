package com.smartentry.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CarVisitant carVisitant;

    @OneToOne
    @JoinColumn(name = "id_carro_morador")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Car carDweller;

    @OneToOne
    @JoinColumn(name = "id_carro_empresa")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CarCompany carCompany;


    private String liberacao;
}
