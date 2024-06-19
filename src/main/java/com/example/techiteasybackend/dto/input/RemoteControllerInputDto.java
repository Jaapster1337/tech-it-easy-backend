package com.example.techiteasybackend.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteControllerInputDto {

    private long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private double price;
    private int originalStock;
}
