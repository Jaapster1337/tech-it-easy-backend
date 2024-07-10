package com.example.techiteasybackend.controllers;

import com.example.techiteasybackend.dto.input.IdInputDto;
import com.example.techiteasybackend.dto.input.RemoteControllerInputDto;
import com.example.techiteasybackend.dto.input.TelevisionInputDto;
import com.example.techiteasybackend.dto.input.WallBracketInputDto;
import com.example.techiteasybackend.dto.output.RemoteControllerOutputDto;
import com.example.techiteasybackend.dto.output.TelevisionOutputDto;
import com.example.techiteasybackend.dto.output.WallBracketOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.models.WallBracket;
import com.example.techiteasybackend.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class WallBracketController {

    private final WallBracketService wbService;

    public WallBracketController(WallBracketService wbService){
        this.wbService = wbService;
    }

    @PostMapping
    public ResponseEntity<WallBracketOutputDto> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto){
        WallBracketOutputDto wallBracketOutputDto = wbService.createWallBracket(wallBracketInputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(wallBracketOutputDto.getId()).toUri();
        return ResponseEntity.created(uri).body(wallBracketOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<WallBracketOutputDto>> returnAllWallBrackets() {
        return ResponseEntity.ok().body(wbService.getAllWallBrackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> getWallBracketById(@PathVariable int id) throws RecordNotFoundException {
        return ResponseEntity.ok().body(wbService.getWallBracketById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> updateWallBracket(@PathVariable int id, @RequestBody WallBracketInputDto wallBracket) {
        return ResponseEntity.ok().body(wbService.updateWallBracket(id,wallBracket));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable int id) {
        return ResponseEntity.ok().body(wbService.deleteWallBracket(id));
    }
}
