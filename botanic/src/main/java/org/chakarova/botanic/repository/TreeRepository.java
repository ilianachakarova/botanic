package org.chakarova.botanic.repository;

import org.chakarova.botanic.model.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<Tree,Long> {
}
