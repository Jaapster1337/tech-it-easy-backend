package com.example.techiteasybackend.controllers;

import com.example.techiteasybackend.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class TelevisionsController {
    private ArrayList<String> tvList = new ArrayList<>();

    @GetMapping
    public ResponseEntity<ArrayList<String>> returnAllTvs(){
        if(!tvList.isEmpty()) {
            return ResponseEntity.ok(tvList);
        } else{
            throw new RecordNotFoundException("no TVs found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTvById(@PathVariable int id) throws RecordNotFoundException{
        if(id >= 0 && id < tvList.size()) {
            return ResponseEntity.ok(tvList.get(id));
        }else{
            throw new RecordNotFoundException("id: " + id+ " has not been found");
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
            throw new RecordNotFoundException("id "+id+" has not been found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTv(@PathVariable int id){
        if(id >= 0 && id < tvList.size()) {
            tvList.remove(id);
            return ResponseEntity.ok(id+" has been remove");
        }else {
            throw new RecordNotFoundException("id "+id+" has not been found");
        }
    }
}
