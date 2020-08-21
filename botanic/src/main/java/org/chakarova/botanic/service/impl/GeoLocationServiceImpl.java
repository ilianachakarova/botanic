package org.chakarova.botanic.service.impl;

import org.chakarova.botanic.model.entity.GeoLocation;
import org.chakarova.botanic.repository.GeoLocationRepository;
import org.chakarova.botanic.service.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeoLocationServiceImpl implements GeoLocationService {
    private final GeoLocationRepository geoLocationRepository;
    @Autowired
    public GeoLocationServiceImpl(GeoLocationRepository geoLocationRepository) {
        this.geoLocationRepository = geoLocationRepository;
    }

    @Override
    public void seedLocationsInDB() {
        for (int i = 1; i <=1000 ; i++) {
            int x = new Random().nextInt(61);
            int y = new Random().nextInt(61);

            GeoLocation location = new GeoLocation(x, y);
            this.geoLocationRepository.save(location);
        }
    }

    @Override
    public GeoLocation pickRandom() {
        int index = new Random().nextInt(999)+1;
        return this.geoLocationRepository.getOne((long) index);
    }

    @Override
    public int getRepositoryCount() {
        return (int) this.geoLocationRepository.count();
    }
}
