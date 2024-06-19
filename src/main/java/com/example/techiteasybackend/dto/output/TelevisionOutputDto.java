package com.example.techiteasybackend.dto.output;

import com.example.techiteasybackend.models.Television;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class TelevisionOutputDto {
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Television.AvailableSize availableSize;
    private Double refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;
    private LocalDate sellDate;
}
