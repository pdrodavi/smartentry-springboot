package com.smartentry.backend.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.Complaint;
import com.smartentry.backend.domain.Dweller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintDTO {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private Integer user;

    private String reclamacao;

    public ComplaintDTO(Complaint complaint) {
        id = complaint.getId();
        data = complaint.getData();
        user = complaint.getUser().getId();
        reclamacao = complaint.getReclamacao();
    }

}
