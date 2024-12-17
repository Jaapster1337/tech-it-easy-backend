package com.example.techiteasybackend.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiModuleInputDto {
    private long id;
    private String name;
    private String type;
    private double price;
}
