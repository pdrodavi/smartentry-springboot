package com.smartentry.backend.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateUserRoleDTO {

    private Integer id;

    private List<Integer> idsRoles;
}
