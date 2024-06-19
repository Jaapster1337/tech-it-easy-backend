package com.example.techiteasybackend.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CiModules")
public class CiModule {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String type;
    private double price;

    public CiModule() {
    }

    public CiModule(long id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
