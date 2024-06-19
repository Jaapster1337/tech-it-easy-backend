package com.example.techiteasybackend.controllers;

import com.example.techiteasybackend.services.WallBracketService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WallBracketController {

    private final WallBracketService wbService;

    public WallBracketController(WallBracketService wbService){
        this.wbService = wbService;
    }
}
