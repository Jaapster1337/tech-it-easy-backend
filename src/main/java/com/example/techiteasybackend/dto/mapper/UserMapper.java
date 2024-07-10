package com.example.techiteasybackend.dto.mapper;

import com.example.techiteasybackend.dto.input.UserInputDto;
import com.example.techiteasybackend.dto.output.UserOutputDto;
import com.example.techiteasybackend.models.User;

public class UserMapper {

    public static User fromInputToModel(UserInputDto userInputDto){
        User u = new User();
        u.setUsername(userInputDto.getUsername());
        u.setPassword(userInputDto.getPassword());
        u.setEnabled(userInputDto.getEnabled());
        u.setApikey(userInputDto.getApikey());
        u.setEmail(userInputDto.getEmail());
        return u;
    }

    public static UserOutputDto fromModelToOutputDto(User user){
        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.setUsername(userOutputDto.getUsername());
        userOutputDto.setPassword(userOutputDto.getPassword());
        userOutputDto.setEnabled(userOutputDto.getEnabled());
        userOutputDto.setApikey(userOutputDto.getApikey());
        userOutputDto.setEmail(userOutputDto.getEmail());
        return userOutputDto;
    }
}
