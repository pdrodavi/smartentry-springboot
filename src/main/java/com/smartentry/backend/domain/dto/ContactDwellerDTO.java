package com.smartentry.backend.domain.dto;

import com.smartentry.backend.domain.ContactDweller;
import com.smartentry.backend.domain.Residence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDwellerDTO {

    private Integer id;

    private String telefone1;

    private String telefone2;

    private String email;

    public ContactDwellerDTO(ContactDweller contactDweller) {
        id = contactDweller.getId();
        telefone1 = contactDweller.getTelefone1();
        telefone2 = contactDweller.getTelefone2();
        email = contactDweller.getEmail();
    }

}
