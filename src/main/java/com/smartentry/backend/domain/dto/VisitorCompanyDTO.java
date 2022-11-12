package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.VisitorCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitorCompanyDTO {

    private Integer id;

    private String nome_empresa;

    private String funcionario;

    private Integer carCompany;

    public VisitorCompanyDTO(VisitorCompany visitorCompany) {
        id = visitorCompany.getId();
        nome_empresa = visitorCompany.getNome_empresa();
        funcionario = visitorCompany.getFuncionario();
        carCompany = visitorCompany.getCarCompany().getId();
    }
}
