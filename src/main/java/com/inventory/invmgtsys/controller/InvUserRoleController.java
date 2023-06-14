package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.dto.RolesDto;
import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.model.Roles;
import com.inventory.invmgtsys.service.CategoryService;
import com.inventory.invmgtsys.service.InvUserRoleService;
import com.inventory.invmgtsys.utils.CommonUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class InvUserRoleController {

    @Autowired
    InvUserRoleService invUserRoleService;
    @GetMapping("/invuserrole")
    public String getinvuserrole(Model model) {
        List<Roles> RolesDtoList = invUserRoleService.getAllUserRoles();
        model.addAttribute("rolesList", RolesDtoList);
        return "invuserrole";
    }
    @PostMapping("/add-roles")

    public String addNewRoles(@ModelAttribute("roles") Roles roles) throws IOException {


        invUserRoleService.addOrUpdateRoles(roles);

        return "redirect:/invuserrole";

    }

    @PostMapping("/update-roles")
    public String updateRoles(@ModelAttribute("roles") Roles roles) throws IOException {

             invUserRoleService.addOrUpdateRoles(roles);

        return "redirect:/invuserrole";

    }
    @PostMapping("/delete-roles")
    public String deleteRoles(@RequestParam("id") Integer id){
        System.out.println("delete controller rolesId"+id);
        RolesDto rolesDto= invUserRoleService.getRolesById(id);
        Roles roles=new Roles();
        roles.setId(rolesDto.getId());
        roles.setName(rolesDto.getName());
        roles.setStatus(false);
        invUserRoleService.addOrUpdateRoles(roles);
        return "redirect:/invuserrole";
    }



}
