package com.smartentry.backend.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "carro_empresa")
public class CarCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_visit_empresa")
    private VisitorCompany visitorCompany;

    @OneToOne
    @JoinColumn(name = "id_ecarro")
    private ECar eCar;
}
