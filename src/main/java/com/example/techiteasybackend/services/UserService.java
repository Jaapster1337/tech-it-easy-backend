package com.example.techiteasybackend.services;


import com.example.techiteasybackend.dto.input.UserInputDto;
import com.example.techiteasybackend.dto.mapper.UserMapper;
import com.example.techiteasybackend.dto.output.UserOutputDto;
import com.example.techiteasybackend.exceptions.UserNameNotFoundException;
import com.example.techiteasybackend.models.Authority;
import com.example.techiteasybackend.models.User;
import com.example.techiteasybackend.repositories.UserRepository;
import com.example.techiteasybackend.utils.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserOutputDto> getAllUsers() {
        User u = new User();
        List<User> allUsers = userRepository.findAll();
        List<UserOutputDto> collection = new ArrayList<>();
        for (User user : allUsers) {
            collection.add(UserMapper.fromModelToOutputDto(user));
        }
        return collection;
    }

    public UserOutputDto getUser(String username) {
        UserOutputDto dto = new UserOutputDto();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            dto = UserMapper.fromModelToOutputDto(user.get());
        }else {
            throw new UserNameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public String createUser(UserInputDto userInputDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userInputDto.setApikey(randomString);
        User newUser = userRepository.save(UserMapper.fromInputToModel(userInputDto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {userRepository.deleteByUsername(username);
    }

    public void updateUser(String username, UserInputDto newUser) {
        if (!userRepository.existsByUsername(username)) throw new UserNameNotFoundException(username);
        User user = userRepository.findByUsername(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsByUsername(username)) throw new UserNameNotFoundException(username);
        User user = userRepository.findByUsername(username).get();
        UserOutputDto userDto = UserMapper.fromModelToOutputDto(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsByUsername(username)) throw new UserNameNotFoundException(username);
        User user =userRepository.findByUsername(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsByUsername(username)) throw new UserNameNotFoundException(username);
        User user = userRepository.findByUsername(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }


}