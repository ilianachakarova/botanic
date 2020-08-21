package org.chakarova.botanic.repository;

import org.chakarova.botanic.model.entity.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoLocationRepository extends JpaRepository<GeoLocation,Long> {
}
