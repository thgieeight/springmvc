package com.inventory.invmgtsys.converter;

import com.inventory.invmgtsys.dto.UserDto;
import com.inventory.invmgtsys.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvUserConverter {


    public User userDtoToUserEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        return user;

    }
    public static UserDto userEntityToUserDto(User user){
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        return userDto;

    }


    public List<UserDto> listEntityToDto(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            userDtoList.add(userEntityToUserDto(user));
        }
        return userDtoList;
    }


}
