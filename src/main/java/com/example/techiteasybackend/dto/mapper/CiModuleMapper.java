package com.example.techiteasybackend.dto.mapper;

import com.example.techiteasybackend.dto.input.CiModuleInputDto;
import com.example.techiteasybackend.dto.output.CiModuleOutputDto;
import com.example.techiteasybackend.models.CiModule;

public class CiModuleMapper {

    public static CiModule fromInputDtoToModel(CiModuleInputDto ciModuleInputDto) {
        CiModule c = new CiModule();
        c.setName(ciModuleInputDto.getName());
        c.setType(ciModuleInputDto.getType());
        c.setPrice(ciModuleInputDto.getPrice());
        return c;
    }

    public static CiModuleOutputDto fromModelToOutputDto(CiModule ciModule) {
        CiModuleOutputDto ciModuleOutputDto = new CiModuleOutputDto();
        ciModuleOutputDto.setId(ciModuleOutputDto.getId());
        ciModuleOutputDto.setName(ciModule.getName());
        ciModuleOutputDto.setType(ciModuleOutputDto.getType());
        ciModuleOutputDto.setPrice(ciModule.getPrice());
        return ciModuleOutputDto;
    }
}

