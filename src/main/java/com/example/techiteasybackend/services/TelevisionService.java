package com.example.techiteasybackend.services;

import com.example.techiteasybackend.dto.input.TelevisionInputDto;
import com.example.techiteasybackend.dto.mapper.TelevisionMapper;
import com.example.techiteasybackend.dto.output.TelevisionOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.models.Television;
import com.example.techiteasybackend.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository tvRepo;

    public TelevisionService(TelevisionRepository tvRepo) {
        this.tvRepo = tvRepo;
    }

    public List<TelevisionOutputDto> getAllTelevisions() {
        Television t = new Television();
        List<Television> allTvs = tvRepo.findAll();
        List<TelevisionOutputDto> allTvOutputList = new ArrayList<>();
        for (Television television : allTvs) {
            allTvOutputList.add(TelevisionMapper.fromModelToOutputDto(television));
        }
        return allTvOutputList;
    }

    public TelevisionOutputDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television t = tvRepo.save(TelevisionMapper.fromInputDtoToModel(televisionInputDto));
        return TelevisionMapper.fromModelToOutputDto(t);
    }

    public TelevisionOutputDto getTvById(long id) {
        Optional<Television> t = tvRepo.findById(id);
        if (t.isPresent()) {
            return TelevisionMapper.fromModelToOutputDto(t.get());
        } else {
            throw new RecordNotFoundException("No tv with this id was found");
        }
    }

    public TelevisionOutputDto updateTv(long id, TelevisionInputDto televisionInputDto) {
        Optional<Television> t = tvRepo.findById(id);
        if (t.isPresent()) {
            t.get().setName(televisionInputDto.getName());
            t.get().setBrand(televisionInputDto.getBrand());
            t.get().setPrice(televisionInputDto.getPrice());
            tvRepo.save(t.get());
            return TelevisionMapper.fromModelToOutputDto(t.get());
        } else {
            throw new RecordNotFoundException("No televisions with id " + id + " found");
        }
    }

    public String deleteTv(long id) {
        Optional<Television> t = tvRepo.findById(id);
        if (t.isPresent()) {
            tvRepo.delete(t.get());
            return "Tv with id " +id+ " has been removed";
        } else {
            throw new RecordNotFoundException("No televisions with id " + id + " found");
        }
    }
}

