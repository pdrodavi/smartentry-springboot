package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.Car;
import com.smartentry.backend.domain.CarCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private Integer id;

    private String modelo;

    private Integer ano;

    private String placa;

    private Integer status;

    public CarDTO(Car car) {
        id = car.getId();
        modelo = car.getModelo();
        ano = car.getAno();
        placa = car.getPlaca();
        status = car.getStatus();
    }

}
