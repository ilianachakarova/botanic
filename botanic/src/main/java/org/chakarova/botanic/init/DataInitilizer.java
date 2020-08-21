package org.chakarova.botanic.init;

import org.chakarova.botanic.service.GeoLocationService;
import org.chakarova.botanic.service.SpeciesService;
import org.chakarova.botanic.service.TownService;
import org.chakarova.botanic.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitilizer implements CommandLineRunner {
    private final TownService townService;
    private final SpeciesService speciesService;
    private final GeoLocationService geoLocationService;
    private final TreeService treeService;

    @Autowired
    public DataInitilizer(TownService townService, SpeciesService speciesService, GeoLocationService geoLocationService, TreeService treeService) {
        this.townService = townService;
        this.speciesService = speciesService;
        this.geoLocationService = geoLocationService;
        this.treeService = treeService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.geoLocationService.getRepositoryCount() == 0) {
            this.geoLocationService.seedLocationsInDB();
        }
        if(this.speciesService.getRepositoryCount()==0){
            this.speciesService.seedSpeciesInDB();
        }

        if(this.townService.getRepositoryCount()==0){
            this.townService.seedTownsInDb();
        }
    }
}
