package com.smartentry.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "correspondencia")
public class Correspondence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipo_correspondencia;

    private Date data_recebimento;

    private String status_entrega;

    @ManyToOne
    @JoinColumn(name = "id_morador")
    private Dweller dweller;

    @ManyToOne
    @JoinColumn(name = "id_func_portaria")
    private ConciergeEmployee conciergeEmployee;
}
