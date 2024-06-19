package com.example.techiteasybackend.services;

import com.example.techiteasybackend.dto.mapper.RemoteControllerMapper;
import com.example.techiteasybackend.dto.output.RemoteControllerOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.models.RemoteController;
import com.example.techiteasybackend.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository rcRepo;

    public RemoteControllerService(RemoteControllerRepository rcRepo) {
        this.rcRepo = rcRepo;
    }

    public RemoteControllerOutputDto getRcById(long id) {
        Optional<RemoteController> r = rcRepo.findById(id);
        if(r.isPresent()){
            return RemoteControllerMapper.fromModelToOutputDto(r.get());
        }else{
            throw new RecordNotFoundException("no remote with this id was found");
        }
    }
}
