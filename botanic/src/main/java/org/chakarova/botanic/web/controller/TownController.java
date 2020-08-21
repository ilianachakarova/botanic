package org.chakarova.botanic.web.controller;

import org.chakarova.botanic.model.entity.Town;
import org.chakarova.botanic.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost")
@RestController
public class TownController {
    private final TownService townService;
    @Autowired
    public TownController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping("/towns")
    public List<Town> getAllTowns(){
        return this.townService.findAll();
    }

    @GetMapping("/towns/{id}")
    public ResponseEntity<Town>getTown(@PathVariable Long id) {
        Optional<Town> town = this.townService.findTownsById(id);
        return town.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
