package com.example.techiteasybackend.controllers;

import com.example.techiteasybackend.dto.input.RemoteControllerInputDto;
import com.example.techiteasybackend.dto.input.TelevisionInputDto;
import com.example.techiteasybackend.dto.output.RemoteControllerOutputDto;
import com.example.techiteasybackend.dto.output.TelevisionOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.services.RemoteControllerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {

    private final RemoteControllerService rcService;

    public RemoteControllerController(RemoteControllerService rcService){
        this.rcService = rcService;
    }

    @PostMapping
    public ResponseEntity<RemoteControllerOutputDto> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto){
        RemoteControllerOutputDto remoteControllerOutputDto = rcService.createRemoteController(remoteControllerInputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(remoteControllerOutputDto.getId()).toUri();
        return ResponseEntity.created(uri).body(remoteControllerOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerOutputDto>> returnAllRemoteControllers(){
        return ResponseEntity.ok().body(rcService.getAllRemoteControllers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerOutputDto> getRcById(@PathVariable int id) throws RecordNotFoundException {
        return ResponseEntity.ok().body(rcService.getRcById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerOutputDto> updateTv(@PathVariable int id, @RequestBody RemoteControllerInputDto remoteController) {
        return ResponseEntity.ok().body(rcService.updateRemoteController(id,remoteController));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRemoteController(@PathVariable int id) {
        return ResponseEntity.ok().body(rcService.deleteRemoteController(id));
    }
}
