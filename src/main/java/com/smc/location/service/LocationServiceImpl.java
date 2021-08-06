package com.smc.location.service;

import com.smc.location.entity.LocationEntity;
import com.smc.location.service.interfaces.LocationService;
import com.smc.location.model.Location;
import com.smc.location.util.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationEntity locationEntity;

    @Autowired
    public LocationServiceImpl(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    @Override
    public Optional<Location> addLocation(Location location) {
        locationEntity.save(location);
        return Optional.of(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationEntity.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationEntity.delete(location);
    }

    @Override
    public void deleteLocationById(Long id) {
        locationEntity.deleteById(id);
    }

    @Override
    public List<Location> findAllLocation() {
        return (List<Location>) locationEntity.findAll();
    }

    @Override
    public Optional<Location> findLocationById(Long id) {
        return Optional.ofNullable(locationEntity.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")));
    }
}
