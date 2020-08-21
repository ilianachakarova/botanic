package org.chakarova.botanic.web.controller;

import org.chakarova.botanic.model.entity.Street;
import org.chakarova.botanic.repository.StreetRepository;
import org.chakarova.botanic.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost")
@RestController
public class StreetController {
    private final StreetService streetService;
    private final StreetRepository streetRepository;
    @Autowired
    public StreetController(StreetService streetService, StreetRepository streetRepository) {

        this.streetService = streetService;
        this.streetRepository = streetRepository;
    }

    @GetMapping("/streets")
    public ResponseEntity<List<Street>> getStreets(){
        return ResponseEntity.ok(this.streetService.getAllStreets());
    }

    @GetMapping("/streets/{id}")
    public ResponseEntity<Street> findStreetById(@PathVariable Long id){
        Optional<Street> street = this.streetRepository.findById(id);
        return street.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }


}
