package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.Visitant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitantDTO {

    private Integer id;

    private String nome;

    private Integer cpf;

    private Integer tipo;

    private Integer status;

    private Integer dweller;

    private Integer vCar;

    public VisitantDTO(Visitant visitant) {
        id = visitant.getId();
        nome = visitant.getNome();
        cpf = visitant.getCpf();
        tipo = visitant.getTipo();
        status = visitant.getStatus();
        dweller = visitant.getDweller().getId();
        vCar = visitant.getCarVisitant().getId();
    }
}
