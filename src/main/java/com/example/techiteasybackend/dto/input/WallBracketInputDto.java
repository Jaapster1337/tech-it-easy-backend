package com.example.techiteasybackend.dto.input;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WallBracketInputDto {

    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;
}
