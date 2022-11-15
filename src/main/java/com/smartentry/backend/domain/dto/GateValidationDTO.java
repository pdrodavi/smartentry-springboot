package com.smartentry.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.smartentry.backend.domain.Car;
import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.CarVisitant;
import com.smartentry.backend.domain.GateValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GateValidationDTO {

    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer carVisitant;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer carDweller;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer carCompany;

    private String liberacao;

    public GateValidationDTO(GateValidation gateValidation) {
        id = gateValidation.getId();
        carVisitant = gateValidation.getCarVisitant().getId();
        carDweller = gateValidation.getCarDweller().getId();
        carCompany = gateValidation.getCarCompany().getId();
        liberacao = gateValidation.getLiberacao();
    }

}
