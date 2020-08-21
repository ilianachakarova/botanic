package org.chakarova.botanic.service;

import org.chakarova.botanic.model.entity.Species;

public interface SpeciesService {
    void seedSpeciesInDB();

    Species getRandomSpecies();
    int getRepositoryCount();
}
