package org.chakarova.botanic.service;

import org.chakarova.botanic.model.entity.Town;

import java.util.List;
import java.util.Optional;

public interface TownService {
    void seedTownsInDb();
    int getRepositoryCount();

    List<Town> findAll();
    Optional<Town> findTownByName(String name);

    Optional<Town> findTownsById(Long id);
}
