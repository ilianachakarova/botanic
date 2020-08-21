package org.chakarova.botanic.service.impl;

import org.chakarova.botanic.model.entity.Species;
import org.chakarova.botanic.repository.SpeciesRepository;
import org.chakarova.botanic.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SpeciesServiceImpl implements SpeciesService {
    private final SpeciesRepository speciesRepository;
    @Autowired
    public SpeciesServiceImpl(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @Override
    public void seedSpeciesInDB() {
        for (int i = 1; i <=250 ; i++) {
            Species testSpecies = new Species();
            testSpecies.setBotanicName("botanicName"+""+i);
            testSpecies.setTrivialName("trivialName"+""+i);
            this.speciesRepository.save(testSpecies);
        }
    }

    @Override
    public Species getRandomSpecies() {
        int index = new Random().nextInt(250)+1;
        return this.speciesRepository.getOne((long) index);
    }

    @Override
    public int getRepositoryCount() {
        return (int) this.speciesRepository.count();
    }
}
