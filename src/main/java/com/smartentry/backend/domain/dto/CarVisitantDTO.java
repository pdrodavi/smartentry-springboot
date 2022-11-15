package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.CarVisitant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarVisitantDTO {

    private Integer id;

    private String placa;

    private Integer status;

    public CarVisitantDTO(CarVisitant carVisitant) {
        id = carVisitant.getId();
        placa = carVisitant.getPlaca();
        status = carVisitant.getStatus();
    }

}
