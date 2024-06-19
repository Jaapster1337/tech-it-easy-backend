package com.example.techiteasybackend.models;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "WallBrackets")
public class WallBracket {
    @Id
    @GeneratedValue
    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

    public WallBracket() {
    }

    public WallBracket(Long id, String size, Boolean adjustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }
}
