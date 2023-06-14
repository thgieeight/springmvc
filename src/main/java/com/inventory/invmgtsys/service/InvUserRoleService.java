package com.inventory.invmgtsys.service;

import com.inventory.invmgtsys.dto.RolesDto;
import com.inventory.invmgtsys.model.Roles;

import java.util.List;
import java.util.Map;

public interface InvUserRoleService {
    List<Roles> getAllUserRoles();
    Roles addOrUpdateRoles(Roles roles);
    RolesDto getRolesById(Integer roleId);
    Roles findRolesById(Integer roleId);
    List<Map<String,String>> findEnabledRoles(boolean status);
}