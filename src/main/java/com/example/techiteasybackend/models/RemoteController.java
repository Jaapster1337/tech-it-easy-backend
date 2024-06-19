package com.example.techiteasybackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RemoteControllers")
public class RemoteController {
    // Getters and Setters
    @Id
    @GeneratedValue
    private long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private double price;
    private int originalStock;
    @OneToOne(mappedBy = "remoteController")
    Television television;

    // Constructor

    public RemoteController() {
    }

    public RemoteController(long id, String compatibleWith, String batteryType, String name, String brand, double price, int originalStock) {
        this.id = id;
        this.compatibleWith = compatibleWith;
        this.batteryType = batteryType;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.originalStock = originalStock;
    }
}
