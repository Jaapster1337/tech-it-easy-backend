package com.example.techiteasybackend.dto.input;

import com.example.techiteasybackend.models.Authority;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter

public class UserInputDto {

    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;
    @JsonSerialize
    public Set<Authority> authorities;
}
