package com.example.techiteasybackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class TelevisionsController {
    private ArrayList<String> tvList = new ArrayList<>();

    @GetMapping
    public ResponseEntity<ArrayList<String>> returnAllTvs(){
        return ResponseEntity.ok(tvList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTvById(@PathVariable int id){
        if(id >= 0 && id < tvList.size()) {
            return ResponseEntity.ok(tvList.get(id));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createTv(@RequestBody String tv){
        tvList.add(tv);
        return ResponseEntity.created(null).body(tv);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTv(@PathVariable int id, @RequestBody String updatedTv){
        if(id >= 0 && id < tvList.size()) {
            tvList.set(id, updatedTv);
            return ResponseEntity.ok(updatedTv);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTv(@PathVariable int id){
        tvList.remove(id);
        return ResponseEntity.ok().build();
    }
}
