package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.Correspondence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorrespondenceDTO {

    private Integer id;

    private String tipo_correspondencia;

    private String data_recebimento;

    private String status_entrega;

    public CorrespondenceDTO(Correspondence correspondence) {
        id = correspondence.getId();
        tipo_correspondencia = correspondence.getTipo_correspondencia();
        data_recebimento = String.valueOf(correspondence.getData_recebimento());
        status_entrega = correspondence.getStatus_entrega();
    }
}
