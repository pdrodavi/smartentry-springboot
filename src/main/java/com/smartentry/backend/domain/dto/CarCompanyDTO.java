package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.ECar;
import com.smartentry.backend.domain.VisitorCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarCompanyDTO {

    private Integer id;

    private Integer visitorCompany;

    private Integer eCar;

    public CarCompanyDTO(CarCompany carCompany) {
        id = carCompany.getId();
        visitorCompany = carCompany.getVisitorCompany().getId();
        eCar = carCompany.getECar().getId();
    }

}
