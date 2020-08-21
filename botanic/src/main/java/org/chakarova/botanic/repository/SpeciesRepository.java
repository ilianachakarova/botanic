package org.chakarova.botanic.repository;

import org.chakarova.botanic.model.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species,Long> {
}
