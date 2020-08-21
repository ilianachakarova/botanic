package org.chakarova.botanic.service;

import org.chakarova.botanic.model.entity.Street;

import java.util.List;
import java.util.Optional;

public interface StreetService {
    Street findStreetByName(String name);
    List<Street>getAllStreets();
    Optional<Street> findStreetById(Long id);
}
