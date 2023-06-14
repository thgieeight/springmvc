package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.converter.InvRolesConverter;
import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.dto.RolesDto;
import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.dto.UserDto;
import com.inventory.invmgtsys.model.Roles;
import com.inventory.invmgtsys.model.User;
import com.inventory.invmgtsys.service.InvUserRoleService;
import com.inventory.invmgtsys.service.InvUserService;
import com.inventory.invmgtsys.utils.CommonUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InvUserController {
    @Autowired
    InvUserService invUserService;

    @Autowired
    InvUserRoleService invUserRoleService;

    @Autowired
    InvRolesConverter invRolesConverter;

    @GetMapping("/invuser")
    public String getuser(Model model) {
        List<User> userDtoList = invUserService.getAllUsers();
        model.addAttribute("userList", userDtoList);
        return "invuser";
    }

    @PostMapping("/add-user")

    public String addNewUser(@ModelAttribute("user") UserDto userDto) throws IOException {

        try {
            invUserService.addorUpdateUser(userDto);


            return "redirect:/invuser";

        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/invuser";

    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute("user") UserDto userDto) throws IOException {

        UserDto userDto1 = (UserDto) invUserService.getAllUsers();

        RolesDto rolesDto=invUserRoleService.getRolesById(userDto.getUserRoleId());
        userDto.setUserRoleId(invRolesConverter.rolesDtoToRolesEntity(rolesDto).getId());

//        invUserService.saveOrUpdateUser(userDto);

        return "redirect:/invuser";
    }
    @PostMapping("/delete-user")
    public String deleteUser(@RequestParam("userId") Integer userId){
        System.out.println("delete controller userId"+userId);
//        UserDto userDto=invUserService.getAllUsers(userId);
//        userDto.setStatus(0);
//        invUserService.saveOrUpdateUser(userDto);
        return "redirect:/sells";
    }


}
