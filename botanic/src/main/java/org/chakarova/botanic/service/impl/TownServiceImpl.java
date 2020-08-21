package org.chakarova.botanic.service.impl;

import org.chakarova.botanic.model.entity.Street;
import org.chakarova.botanic.model.entity.Town;
import org.chakarova.botanic.repository.StreetRepository;
import org.chakarova.botanic.repository.TownRepository;
import org.chakarova.botanic.service.TownService;
import org.chakarova.botanic.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final StreetRepository streetRepository;
    private final TreeService treeService;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, StreetRepository streetRepository, TreeService treeService) {
        this.townRepository = townRepository;
        this.streetRepository = streetRepository;
        this.treeService = treeService;
    }

    @Override
    public void seedTownsInDb() {
        for (int i = 0; i <10 ; i++) {
            Town testTown = new Town();
            testTown.setName("test town"+ ""+ i);
            testTown.setPostCode("000"+""+i);
            int index = new Random().nextInt(3)+1;
            //int index = new Random().nextInt(191)+10; //real
            List<Street>streets = new ArrayList<>();
            for (int j = 0; j <index; j++) {
                Street street = new Street();
                street.setName(String.format("Str. %s town %s",j,i));
                street.setAdministrativeAbbreviation("ABB"+j);
                int randomNumberOfTrees = new Random().nextInt(5);//test
                //int randomNumberOfTrees = new Random().nextInt(800);//real
                street.setTrees(this.treeService.generateRandomList(randomNumberOfTrees));
                this.streetRepository.saveAndFlush(street);
                streets.add(street);
            }
            testTown.setStreets(streets);
            this.townRepository.saveAndFlush(testTown);
        }
    }

    @Override
    public int getRepositoryCount() {
        return (int) this.townRepository.count();
    }

    @Override
    public List<Town> findAll() {
        return this.townRepository.findAll();
    }

    @Override
    public Optional<Town> findTownByName(String name) {
        return this.townRepository.findByName(name);
    }

    @Override
    public Optional<Town> findTownsById(Long id) {
        return this.townRepository.findById(id);
    }
}
