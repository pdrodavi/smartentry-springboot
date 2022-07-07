package com.smartentry.backend.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Correspondence implements Serializable {

    private Integer id;

    private String tipo_correspondencia;

    private String data_recebimento;

    private String status_entrega;
}
