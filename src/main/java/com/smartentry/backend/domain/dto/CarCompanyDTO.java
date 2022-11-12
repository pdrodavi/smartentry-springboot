package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.CarCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarCompanyDTO {

    private Integer id;

    private String placa;

    private Integer status;

    public CarCompanyDTO(CarCompany carCompany) {
        id = carCompany.getId();
        placa = carCompany.getPlaca();
        status = carCompany.getStatus();
    }

}
