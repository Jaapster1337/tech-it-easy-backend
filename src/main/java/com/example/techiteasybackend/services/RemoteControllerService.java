package com.example.techiteasybackend.services;

import com.example.techiteasybackend.dto.input.RemoteControllerInputDto;
import com.example.techiteasybackend.dto.mapper.RemoteControllerMapper;
import com.example.techiteasybackend.dto.output.RemoteControllerOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.models.RemoteController;
import com.example.techiteasybackend.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository rcRepo;

    public RemoteControllerService(RemoteControllerRepository rcRepo) {
        this.rcRepo = rcRepo;
    }

    public List<RemoteControllerOutputDto> getAllRemoteControllers(){
        RemoteController r = new RemoteController();
        List<RemoteController> allRemoteControllers = rcRepo.findAll();
        List<RemoteControllerOutputDto> allRemoteControllerOutputList = new ArrayList<>();
        for(RemoteController remoteController: allRemoteControllers){
            allRemoteControllerOutputList.add(RemoteControllerMapper.fromModelToOutputDto(remoteController));
        }
        return allRemoteControllerOutputList;
    }

    public RemoteControllerOutputDto createRemoteController(RemoteControllerInputDto remoteControllerInputDto){
        RemoteController r = rcRepo.save(RemoteControllerMapper.fromInputDtoToModel(remoteControllerInputDto));
        return RemoteControllerMapper.fromModelToOutputDto(r);
    }

    public RemoteControllerOutputDto updateRemoteController(long id, RemoteControllerInputDto remoteControllerInputDto){
        Optional<RemoteController> r = rcRepo.findById(id);
        if(r.isPresent()){
            r.get().setCompatibleWith(remoteControllerInputDto.getCompatibleWith());
            r.get().setBatteryType(remoteControllerInputDto.getBatteryType());
            r.get().setName(remoteControllerInputDto.getName());
            r.get().setBrand(remoteControllerInputDto.getBrand());
            r.get().setPrice(remoteControllerInputDto.getPrice());
            r.get().setOriginalStock(remoteControllerInputDto.getOriginalStock());
            rcRepo.save(r.get());
            return RemoteControllerMapper.fromModelToOutputDto(r.get());
        } else {
            throw new RecordNotFoundException("No remote with " +id+ " found");
        }
    }

    public RemoteControllerOutputDto getRcById(long id) {
        Optional<RemoteController> r = rcRepo.findById(id);
        if(r.isPresent()){
            return RemoteControllerMapper.fromModelToOutputDto(r.get());
        }else{
            throw new RecordNotFoundException("no remote with this id was found");
        }
    }

    public String deleteRemoteController(long id){
        Optional<RemoteController> r = rcRepo.findById(id);
        if (r.isPresent()) {
            rcRepo.delete(r.get());
            return "remote with id " +id+ " has been removed";
        } else {
            throw new RecordNotFoundException("No remotes with id " + id + " found");
        }
    }
}
