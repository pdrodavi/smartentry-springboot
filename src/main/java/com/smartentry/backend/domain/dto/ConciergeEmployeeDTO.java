package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.ConciergeEmployee;
import com.smartentry.backend.domain.Dweller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConciergeEmployeeDTO {

    private Integer id;

    private String nome;

    private Integer cpf;

    private Integer status;

    private String data_admissao;

    private String data_demissao;

    private String turno;

    public ConciergeEmployeeDTO(ConciergeEmployee conciergeEmployee) {
        id = conciergeEmployee.getId();
        nome = conciergeEmployee.getNome();
        cpf = (conciergeEmployee.getCpf());
        status = conciergeEmployee.getStatus();
        data_admissao = conciergeEmployee.getData_admissao();
        data_demissao = conciergeEmployee.getData_demissao();
        turno = conciergeEmployee.getTurno();
    }
}
