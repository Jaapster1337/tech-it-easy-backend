package com.example.techiteasybackend.dto.mapper;

import com.example.techiteasybackend.dto.input.WallBracketInputDto;
import com.example.techiteasybackend.dto.output.WallBracketOutputDto;
import com.example.techiteasybackend.models.WallBracket;

public class WallBracketMapper {

    public static WallBracket fromInputDtoToModel(WallBracketInputDto wallBracketInputDto){
        WallBracket w = new WallBracket();
        w.setName(wallBracketInputDto.getName());
        w.setSize(wallBracketInputDto.getSize());
        w.setAdjustable(wallBracketInputDto.getAdjustable());
        w.setPrice(wallBracketInputDto.getPrice());
        return w;
    }

    public static WallBracketOutputDto fromModelToOutputDto(WallBracket wallBracket){
        WallBracketOutputDto wallBracketOutputDto = new WallBracketOutputDto();
        wallBracketOutputDto.setId(wallBracketOutputDto.getId());
        wallBracketOutputDto.setName(wallBracket.getName());
        wallBracketOutputDto.setSize(wallBracket.getSize());
        wallBracketOutputDto.setAdjustable(wallBracketOutputDto.getAdjustable());
        wallBracketOutputDto.setPrice(wallBracket.getPrice());
        return wallBracketOutputDto;
    }
}
