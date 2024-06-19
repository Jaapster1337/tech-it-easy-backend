package com.example.techiteasybackend.services;

import com.example.techiteasybackend.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CiModuleService {

    private CiModuleRepository cmRepo;

    public CiModuleService(CiModuleRepository cmRepo) {
        this.cmRepo = cmRepo;
    }
}
