package com.smartentry.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smartentry.backend.domain.Block;
import com.smartentry.backend.domain.Complaint;
import com.smartentry.backend.domain.Residence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResidenceDTO {

    private Integer id;

    private Integer numero;

    private Integer id_bloco;

    public ResidenceDTO(Residence complaint) {
        id = complaint.getId();
        numero = complaint.getNumero();
        id_bloco = complaint.getId_bloco().getId();
    }

}
