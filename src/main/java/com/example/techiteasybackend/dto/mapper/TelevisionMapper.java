package com.example.techiteasybackend.dto.mapper;

import com.example.techiteasybackend.dto.input.TelevisionInputDto;
import com.example.techiteasybackend.dto.output.TelevisionOutputDto;
import com.example.techiteasybackend.models.Television;

public class TelevisionMapper {

    public static Television fromInputDtoToModel(TelevisionInputDto televisionInputDto){
        Television t = new Television();
        t.setType(televisionInputDto.getType());
        t.setBrand(televisionInputDto.getBrand());
        t.setName(televisionInputDto.getName());
        t.setPrice(televisionInputDto.getPrice());
        t.setAvailableSize(televisionInputDto.getAvailableSize());
        t.setRefreshRate(televisionInputDto.getRefreshRate());
        t.setScreenType(televisionInputDto.getScreenType());
        t.setScreenQuality(televisionInputDto.getScreenQuality());
        t.setSmartTv(televisionInputDto.getSmartTv());
        t.setWifi(televisionInputDto.getWifi());
        t.setVoiceControl(televisionInputDto.getVoiceControl());
        t.setHdr(televisionInputDto.getHdr());
        t.setBluetooth(televisionInputDto.getBluetooth());
        t.setAmbiLight(televisionInputDto.getAmbiLight());
        t.setOriginalStock(televisionInputDto.getOriginalStock());
        t.setSold(televisionInputDto.getSold());
        t.setRemoteController(t.getRemoteController());
        return t;
    }

    public static TelevisionOutputDto fromModelToOutputDto(Television television){
        TelevisionOutputDto televisionOutputDto = new TelevisionOutputDto();
        televisionOutputDto.setId(television.getId());
        televisionOutputDto.setType(television.getType());
        televisionOutputDto.setBrand(television.getBrand());
        televisionOutputDto.setName(television.getName());
        televisionOutputDto.setPrice(television.getPrice());
        televisionOutputDto.setAvailableSize(television.getAvailableSize());
        televisionOutputDto.setRefreshRate(television.getRefreshRate());
        televisionOutputDto.setScreenType(television.getScreenType());
        televisionOutputDto.setScreenQuality(television.getScreenQuality());
        televisionOutputDto.setSmartTv(television.getSmartTv());
        televisionOutputDto.setWifi(television.getWifi());
        televisionOutputDto.setVoiceControl(television.getVoiceControl());
        televisionOutputDto.setHdr(television.getHdr());
        televisionOutputDto.setBluetooth(television.getBluetooth());
        televisionOutputDto.setAmbiLight(television.getAmbiLight());
        return televisionOutputDto;
    }
}
