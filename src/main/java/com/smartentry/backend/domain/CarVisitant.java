package com.smartentry.backend.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "carro_visitante")
public class CarVisitant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_visitante")
    private Visitant visitant;

    @OneToOne
    @JoinColumn(name = "id_vcarro")
    private VCar vCar;
}
