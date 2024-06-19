package com.example.techiteasybackend.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Televisions")
@Getter
@Setter
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private AvailableSize availableSize;
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

    @OneToOne
    RemoteController remoteController;

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    public enum AvailableSize {
        SIZE_32(32.0),
        SIZE_40(40.0),
        SIZE_50(50.0),
        SIZE_55(55.0),
        SIZE_65(65.0),
        SIZE_75(75.0);

        private final double size;

        AvailableSize(double size) {
            this.size = size;
        }

        public double getSize() {
            return size;
        }
    }

    // Default constructor
    public Television() {
    }

    // Constructor with all fields
    public Television(Long id, String type, String brand, String name, Double price, AvailableSize availableSize,
                      Double refreshRate, String screenType, String screenQuality, Boolean smartTv, Boolean wifi,
                      Boolean voiceControl, Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock,
                      Integer sold) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
    }
}
