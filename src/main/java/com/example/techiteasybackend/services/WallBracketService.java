package com.example.techiteasybackend.services;

import com.example.techiteasybackend.dto.input.TelevisionInputDto;
import com.example.techiteasybackend.dto.input.WallBracketInputDto;
import com.example.techiteasybackend.dto.mapper.TelevisionMapper;
import com.example.techiteasybackend.dto.mapper.WallBracketMapper;
import com.example.techiteasybackend.dto.output.TelevisionOutputDto;
import com.example.techiteasybackend.dto.output.WallBracketOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.models.Television;
import com.example.techiteasybackend.models.WallBracket;
import com.example.techiteasybackend.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wbRepo;

    public WallBracketService(WallBracketRepository wbRepo) {
        this.wbRepo = wbRepo;
    }

    public List<WallBracketOutputDto> getAllWallBrackets() {
        WallBracket t = new WallBracket();
        List<WallBracket> allWallBrackets = wbRepo.findAll();
        List<WallBracketOutputDto> allWallBracketOutputList = new ArrayList<>();
        for (WallBracket wallbracket : allWallBrackets) {
            allWallBracketOutputList.add(WallBracketMapper.fromModelToOutputDto(wallbracket));
        }
        return allWallBracketOutputList;
    }

    public WallBracketOutputDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket w = wbRepo.save(WallBracketMapper.fromInputDtoToModel(wallBracketInputDto));
        return WallBracketMapper.fromModelToOutputDto(w);
    }

    public WallBracketOutputDto getWallBracketById(long id) {
        Optional<WallBracket> w = wbRepo.findById(id);
        if (w.isPresent()) {
            return WallBracketMapper.fromModelToOutputDto(w.get());
        } else {
            throw new RecordNotFoundException("No wallbracket with id " + id + " found");
        }
    }

    public WallBracketOutputDto updateWallBracket(long id, WallBracketInputDto wallBracketInputDto) {
        Optional<WallBracket> w = wbRepo.findById(id);
        if (w.isPresent()) {
            w.get().setSize(wallBracketInputDto.getSize());
            w.get().setAdjustable(wallBracketInputDto.getAdjustable());
            w.get().setName(wallBracketInputDto.getName());
            w.get().setPrice(wallBracketInputDto.getPrice());
            wbRepo.save(w.get());
            return WallBracketMapper.fromModelToOutputDto(w.get());
        } else {
            throw new RecordNotFoundException("No wallbracket with id " + id + " found");
        }
    }

    public String deleteWallBracket(long id) {
        Optional<WallBracket> w = wbRepo.findById(id);
        if (w.isPresent()) {
            wbRepo.delete(w.get());
            return "Wallbracket with id " +id+ " has been removed";
        } else {
            throw new RecordNotFoundException("No wallbrackets with id " + id + " found");
        }
    }
}
