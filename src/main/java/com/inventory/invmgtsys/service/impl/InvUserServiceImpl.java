package com.inventory.invmgtsys.service.impl;

import com.inventory.invmgtsys.converter.InvRolesConverter;
import com.inventory.invmgtsys.converter.InvUserConverter;
import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.RolesDto;
import com.inventory.invmgtsys.dto.UserDto;
import com.inventory.invmgtsys.model.Category;
import com.inventory.invmgtsys.model.Roles;
import com.inventory.invmgtsys.model.User;
import com.inventory.invmgtsys.repo.UserRepo;
import com.inventory.invmgtsys.service.InvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvUserServiceImpl implements InvUserService {
    @Autowired
    UserRepo userRepo;


    @Autowired
    InvUserConverter userConverter;

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepo.findById(userId).get();
    }



    @Override
    public UserDto getUserById(Integer userId) {
        return userConverter.userEntityToUserDto(userRepo.findById(userId).get());
    }


    @Override
    public UserDto addorUpdateUser(UserDto userDto)
    {

        User user= userConverter.userDtoToUserEntity(userDto);
        User user1=userRepo.save(user);
        UserDto userDto1=userConverter.userEntityToUserDto(user1);
        return userDto1;
    }

}