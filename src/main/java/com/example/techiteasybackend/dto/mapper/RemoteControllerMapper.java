package com.example.techiteasybackend.dto.mapper;

import com.example.techiteasybackend.dto.input.RemoteControllerInputDto;
import com.example.techiteasybackend.dto.output.RemoteControllerOutputDto;
import com.example.techiteasybackend.models.RemoteController;

public class RemoteControllerMapper {

    public static RemoteController fromInputDtoToModel(RemoteControllerInputDto remoteControllerInputDto){
        RemoteController r = new RemoteController();
        r.setName(remoteControllerInputDto.getName());
        r.setBrand(remoteControllerInputDto.getBrand());
        r.setBatteryType(remoteControllerInputDto.getBatteryType());
        r.setCompatibleWith(remoteControllerInputDto.getCompatibleWith());
        r.setOriginalStock(remoteControllerInputDto.getOriginalStock());
        r.setPrice(remoteControllerInputDto.getPrice());
        return r;
    }

    public static RemoteControllerOutputDto fromModelToOutputDto(RemoteController remoteController){
        RemoteControllerOutputDto remoteControllerOutputDto = new RemoteControllerOutputDto();
        remoteControllerOutputDto.setId(remoteController.getId());
        remoteControllerOutputDto.setBrand(remoteController.getBrand());
        remoteControllerOutputDto.setName(remoteController.getName());
        remoteControllerOutputDto.setBatteryType(remoteController.getBatteryType());
        remoteControllerOutputDto.setCompatibleWith(remoteController.getCompatibleWith());
        remoteControllerOutputDto.setOriginalStock(remoteController.getOriginalStock());
        remoteControllerOutputDto.setPrice(remoteController.getPrice());
        return remoteControllerOutputDto;
    }
}
