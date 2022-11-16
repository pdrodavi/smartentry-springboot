package com.smartentry.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smartentry.backend.domain.ConciergeEmployee;
import com.smartentry.backend.domain.Dweller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConciergeEmployeeDTO {

    private Integer id;

    private String nome;

    private String cpf;

    private Integer status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String data_admissao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_demissao;

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
