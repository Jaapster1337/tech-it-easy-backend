package com.example.techiteasybackend.services;

import com.example.techiteasybackend.dto.input.CiModuleInputDto;
import com.example.techiteasybackend.dto.mapper.CiModuleMapper;
import com.example.techiteasybackend.dto.output.CiModuleOutputDto;
import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import com.example.techiteasybackend.models.CiModule;
import com.example.techiteasybackend.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private CiModuleRepository cmRepo;

    public CiModuleService(CiModuleRepository cmRepo) {
        this.cmRepo = cmRepo;
    }

    public List<CiModuleOutputDto> getAllCIModules() {
        List<CiModule> ciModules = cmRepo.findAll();
        List<CiModuleOutputDto> dtos = new ArrayList<>();
        for (CiModule ci : ciModules) {
            dtos.add(CiModuleMapper.fromModelToOutputDto(ci));
        }
        return dtos;
    }

    public CiModuleOutputDto getCIModule(long id) {
        Optional<CiModule> ciModule = cmRepo.findById(id);
        if(ciModule.isPresent()) {
            CiModuleOutputDto ci = CiModuleMapper.fromModelToOutputDto(ciModule.get());
            return ci;
        } else {
            throw new RecordNotFoundException("No ci-module found");
        }
    }

    public CiModuleOutputDto addCIModule(CiModuleInputDto ciModuleInputDto) {
        CiModule c = cmRepo.save(CiModuleMapper.fromInputDtoToModel(ciModuleInputDto));
        return CiModuleMapper.fromModelToOutputDto(c);
    }

    public void deleteCIModule(Long id) {
        cmRepo.deleteById(id);
    }

    public CiModuleOutputDto updateCIModule(Long id, CiModuleInputDto ciModuleInputDto) {
        if(!cmRepo.existsById(id)) {
            throw new RecordNotFoundException("No ci-module found");
        }
        CiModule storedCIModule = cmRepo.findById(id).orElse(null);
        storedCIModule.setType(ciModuleInputDto.getType());
        storedCIModule.setName(ciModuleInputDto.getName());
        storedCIModule.setPrice(ciModuleInputDto.getPrice());
        cmRepo.save(storedCIModule);
        return CiModuleMapper.fromModelToOutputDto(storedCIModule);
    }
}
