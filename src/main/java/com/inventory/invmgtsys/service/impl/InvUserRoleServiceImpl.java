package com.inventory.invmgtsys.service.impl;

import com.inventory.invmgtsys.converter.InvRolesConverter;
import com.inventory.invmgtsys.converter.ProductConverter;
import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.dto.RolesDto;
import com.inventory.invmgtsys.model.Roles;
import com.inventory.invmgtsys.repo.RolesRepo;
import com.inventory.invmgtsys.service.InvUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InvUserRoleServiceImpl implements InvUserRoleService {
    @Autowired
    RolesRepo rolesRepo;

    @Autowired
    InvRolesConverter rolesConverter;
    @Override
    public List<Roles> getAllUserRoles() {
        return rolesRepo.findAll();
    }

    @Override
    public Roles addOrUpdateRoles(Roles roles) {
        return rolesRepo.save(roles);
    }

    @Override
    public Roles findRolesById(Integer roleId) {
        return rolesRepo.findById(roleId).get();
    }

    @Override
    public RolesDto getRolesById(Integer rolesId) {
        return rolesConverter.rolesEntityToRolesDto(rolesRepo.findById(rolesId).get());
    }

    @Override
    public List<Map<String, String>> findEnabledRoles(boolean status) {
        return rolesRepo.findEnabledRoles(status);
    }
}