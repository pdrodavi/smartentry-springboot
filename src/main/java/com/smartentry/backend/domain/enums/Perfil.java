package com.smartentry.backend.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER"),
    MANAGER(3, "ROLE_MANAGER");

    private int cod;

    private String descricao;

    public static Perfil toEnum(Integer cod) {
        if (cod ==  null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido " + cod);
    }
}
