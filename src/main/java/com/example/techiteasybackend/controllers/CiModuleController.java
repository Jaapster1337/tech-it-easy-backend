package com.example.techiteasybackend.controllers;

import com.example.techiteasybackend.dto.input.CiModuleInputDto;
import com.example.techiteasybackend.dto.output.CiModuleOutputDto;
import com.example.techiteasybackend.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CiModuleController {

    private final CiModuleService cmService;

    public CiModuleController(CiModuleService cmService){
        this.cmService = cmService;
    }

    @GetMapping("/cimodules")
    public ResponseEntity<List<CiModuleOutputDto>> getAllCIModules() {

        List<CiModuleOutputDto> dtos = cmService.getAllCIModules();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/cimodules/{id}")
    public ResponseEntity<CiModuleOutputDto> getCIModule(@PathVariable("id") Long id) {

        CiModuleOutputDto ciModuleDto = cmService.getCIModule(id);

        return ResponseEntity.ok(ciModuleDto);
    }

    @PostMapping("/cimodules")
    public ResponseEntity<CiModuleOutputDto> addCIModule(@RequestBody CiModuleInputDto dto) {
        CiModuleOutputDto ciModuleOutputDto = cmService.addCIModule(dto);
        return ResponseEntity.created(null).body(ciModuleOutputDto);
    }

    @DeleteMapping("/cimodules/{id}")
    public ResponseEntity<Object> deleteCIModule(@PathVariable("id") Long id) {

        cmService.deleteCIModule(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cimodules/{id}")
    public ResponseEntity<CiModuleOutputDto> updateCIModule(@PathVariable("id") Long id, @RequestBody CiModuleInputDto ciModuleInputDto) {
        CiModuleOutputDto ciModuleOutputDto = cmService.updateCIModule(id, ciModuleInputDto);
        return ResponseEntity.ok(ciModuleOutputDto);
    }
}
