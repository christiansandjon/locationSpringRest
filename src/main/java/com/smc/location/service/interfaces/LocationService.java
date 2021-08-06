package com.smc.location.service.interfaces;

import com.smc.location.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    Optional<Location> addLocation(Location location);
    void updateLocation(Location location);
    void deleteLocation(Location location);
    void deleteLocationById(Long id);
    List<Location> findAllLocation();
    Optional<Location> findLocationById(Long id);
}
