package com.example.techiteasybackend.controllers;

import com.example.techiteasybackend.dto.output.RemoteControllerOutputDto;
import com.example.techiteasybackend.dto.output.TelevisionOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteControllerController {

    private final RemoteControllerService rcService;

    public RemoteControllerController(RemoteControllerService rcService){
        this.rcService = rcService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerOutputDto> getRcById(@PathVariable int id) throws RecordNotFoundException {
        return ResponseEntity.ok().body(rcService.getRcById(id));
    }
}
