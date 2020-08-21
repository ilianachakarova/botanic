package org.chakarova.botanic.repository;

import org.chakarova.botanic.model.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample,Long> {
}
