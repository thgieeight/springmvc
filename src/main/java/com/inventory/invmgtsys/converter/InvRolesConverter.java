package com.inventory.invmgtsys.converter;

import com.inventory.invmgtsys.dto.RolesDto;
import com.inventory.invmgtsys.model.Roles;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvRolesConverter {
    public Roles rolesDtoToRolesEntity(RolesDto rolesDto) {
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setName(rolesDto.getName());
        roles.setStatus(rolesDto.isStatus());
        return roles;

    }
    public static RolesDto rolesEntityToRolesDto(Roles roles){
        RolesDto rolesDto =new RolesDto();
        rolesDto.setId(roles.getId());
        rolesDto.setName(roles.getName());
        rolesDto.setStatus(roles.isStatus());
        return rolesDto;

    }


    public List<RolesDto> listEntityToDto(List<Roles> roless) {
        List<RolesDto> rolesDtoList = new ArrayList<>();
        for (Roles roles : roless) {
            rolesDtoList.add(rolesEntityToRolesDto(roles));
        }
        return rolesDtoList;
    }
}
