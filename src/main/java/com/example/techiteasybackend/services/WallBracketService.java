package com.example.techiteasybackend.services;

import com.example.techiteasybackend.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

@Service
public class WallBracketService {

    private final WallBracketRepository wbRepo;

    public WallBracketService(WallBracketRepository wbRepo) {
        this.wbRepo = wbRepo;
    }
}
