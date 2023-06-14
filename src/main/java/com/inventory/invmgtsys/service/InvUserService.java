package com.inventory.invmgtsys.service;

import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.RolesDto;
import com.inventory.invmgtsys.dto.UserDto;
import com.inventory.invmgtsys.model.User;

import java.util.List;

public interface InvUserService {
    User saveOrUpdateUser(User user);
    List<User> getAllUsers();
    User findUserById(Integer userId);
    UserDto getUserById(Integer userId);

    UserDto addorUpdateUser(UserDto userDto);

}