package org.chakarova.botanic.service;

import org.chakarova.botanic.model.entity.Tree;

import java.util.List;

public interface TreeService {

   List<Tree> generateRandomList(int randomNumberOfTrees);

   int getRepositoryCount();
}
