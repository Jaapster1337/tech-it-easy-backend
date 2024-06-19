package com.example.techiteasybackend.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteControllerOutputDto {

    private long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private double price;
    private int originalStock;
}
