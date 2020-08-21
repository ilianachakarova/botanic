package org.chakarova.botanic.service.impl;

import org.chakarova.botanic.model.entity.Street;
import org.chakarova.botanic.repository.StreetRepository;
import org.chakarova.botanic.service.StreetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    public StreetServiceImpl(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public Street findStreetByName(String name) {
        return this.streetRepository.findStreetByName(name);
    }

    @Override
    public List<Street> getAllStreets() {
        return this.streetRepository.findAll();
    }

    @Override
    public Optional<Street> findStreetById(Long id) {
        return this.streetRepository.findById(id);
    }
}
