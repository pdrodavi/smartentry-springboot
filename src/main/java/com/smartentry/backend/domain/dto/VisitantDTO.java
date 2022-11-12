package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.CarVisitant;
import com.smartentry.backend.domain.VCar;
import com.smartentry.backend.domain.Visitant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitantDTO {

    private Integer id;

    private Integer visitant;

    private Integer dweller;

    private Integer vCar;

    public VisitantDTO(CarVisitant carVisitant) {
        id = carVisitant.getId();
        visitant = carVisitant.getVisitant().getId();
    }
}
