package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.Correspondence;
import com.smartentry.backend.domain.Dweller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DwellerDTO {

    private Integer id;

    private String nome;

    private String cpf;

    private String rg;

    private Integer status;

    private Integer residencia;

    private Integer contactDweller;

    private Integer carro;

    public DwellerDTO(Dweller dweller) {
        id = dweller.getId();
        nome = dweller.getNome();
        cpf = (dweller.getCpf());
        rg = dweller.getRg();
        status = dweller.getStatus();
        residencia = dweller.getResidence().getId();
        contactDweller = dweller.getContactDweller().getId();
        carro = dweller.getCar().getId();
    }
}
