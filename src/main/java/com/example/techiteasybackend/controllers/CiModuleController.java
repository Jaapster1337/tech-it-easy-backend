package com.example.techiteasybackend.controllers;

import com.example.techiteasybackend.services.CiModuleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CiModuleController {

    private final CiModuleService cmService;

    public CiModuleController(CiModuleService cmService){
        this.cmService = cmService;
    }
}
