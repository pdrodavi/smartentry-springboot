package com.smartentry.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smartentry.backend.domain.Correspondence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorrespondenceDTO {

    private Integer id;

    private String tipo_correspondencia;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_recebimento;

    private String status_entrega;

    private Integer dweller;

    private Integer conciergeEmployee;

    public CorrespondenceDTO(Correspondence correspondence) {
        id = correspondence.getId();
        tipo_correspondencia = correspondence.getTipo_correspondencia();
        data_recebimento = (correspondence.getData_recebimento());
        status_entrega = correspondence.getStatus_entrega();
        dweller = correspondence.getDweller().getId();
        conciergeEmployee = correspondence.getConciergeEmployee().getId();
    }
}
