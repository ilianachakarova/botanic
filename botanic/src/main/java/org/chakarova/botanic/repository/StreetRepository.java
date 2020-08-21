package org.chakarova.botanic.repository;

import org.chakarova.botanic.model.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street,Long> {
    Street findStreetByName(String name);
}
