package com.example.techiteasybackend.controllers;

import com.example.techiteasybackend.dto.input.TelevisionInputDto;
import com.example.techiteasybackend.dto.output.TelevisionOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.models.Television;
import com.example.techiteasybackend.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    private final TelevisionService tvService;

    public TelevisionController(TelevisionService tvService) {
        this.tvService = tvService;
    }

    @PostMapping
    public ResponseEntity<TelevisionOutputDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto){
        TelevisionOutputDto televisionOutputDto = tvService.createTelevision(televisionInputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(televisionOutputDto.getId()).toUri();
        return ResponseEntity.created(uri).body(televisionOutputDto);
    }


    @GetMapping
    public ResponseEntity<List<TelevisionOutputDto>> returnAllTvs() {
        return ResponseEntity.ok().body(tvService.getAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> getTvById(@PathVariable int id) throws RecordNotFoundException {
        return ResponseEntity.ok().body(tvService.getTvById(id));
    }

    @PostMapping
    public ResponseEntity<TelevisionOutputDto> createTv(@Valid @RequestBody TelevisionInputDto televisionInputDto, BindingResult br) {
        TelevisionOutputDto televisionOutputDto = tvService.createTelevision(televisionInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + televisionOutputDto.getId()).toUriString());
        return ResponseEntity.created(uri).body(televisionOutputDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> updateTv(@PathVariable int id, @RequestBody TelevisionInputDto television) {
        return ResponseEntity.ok().body(tvService.updateTv(id,television));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTv(@PathVariable int id) {
        return ResponseEntity.ok().body(tvService.deleteTv(id));
    }
}
