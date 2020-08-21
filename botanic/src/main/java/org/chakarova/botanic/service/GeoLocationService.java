package org.chakarova.botanic.service;

import org.chakarova.botanic.model.entity.GeoLocation;

public interface GeoLocationService {
   void seedLocationsInDB();
   GeoLocation pickRandom();
   int getRepositoryCount();
}
