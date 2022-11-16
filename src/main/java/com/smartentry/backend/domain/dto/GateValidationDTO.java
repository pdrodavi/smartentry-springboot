package com.smartentry.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.smartentry.backend.domain.Car;
import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.CarVisitant;
import com.smartentry.backend.domain.GateValidation;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GateValidationDTO {

    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String placa_morador;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String placa_visitante;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String placa_empresa;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @JsonFormat(pattern = "HH:mm:ss")
    private Time hora;

    private String liberacao;
    public GateValidationDTO(GateValidation gateValidation) {
        id = gateValidation.getId();
        placa_morador = gateValidation.getPlaca_morador();
        placa_visitante = gateValidation.getPlaca_visitante();
        placa_empresa = gateValidation.getPlaca_empresa();
        data = gateValidation.getData();
        hora = gateValidation.getHora();
        liberacao = gateValidation.getLiberacao();
    }

}
