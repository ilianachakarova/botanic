package org.chakarova.botanic.service.impl;

import org.chakarova.botanic.model.entity.Tree;
import org.chakarova.botanic.repository.TreeRepository;
import org.chakarova.botanic.service.GeoLocationService;
import org.chakarova.botanic.service.SampleService;
import org.chakarova.botanic.service.SpeciesService;
import org.chakarova.botanic.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TreeServiceImpl implements TreeService {
    private final TreeRepository treeRepository;
    private final SampleService sampleService;
    private final SpeciesService speciesService;
    private final GeoLocationService geoLocationService;
    @Autowired
    public TreeServiceImpl(TreeRepository treeRepository, SampleService sampleService, SpeciesService speciesService,GeoLocationService geoLocationService) {
        this.treeRepository = treeRepository;
        this.sampleService = sampleService;
        this.speciesService = speciesService;
        this.geoLocationService = geoLocationService;

    }


    @Override
    public List<Tree> generateRandomList(int randomNumberOfTrees) {
        List<Tree> trees = new ArrayList<>();
        for (int i = 0; i <randomNumberOfTrees; i++) {
            Tree tree = new Tree();
            tree.setNumber((long) i);
            tree.setPlantationDate(new Date());
            tree.setSamples(this.sampleService.generateSamplesList());
            tree.setSpecies(this.speciesService.getRandomSpecies());
            tree.setGeoLocation(this.geoLocationService.pickRandom());
            this.treeRepository.saveAndFlush(tree);
            trees.add(tree);
        }

        return trees;
    }

    @Override
    public int getRepositoryCount() {
        return (int) this.treeRepository.count();
    }


}
