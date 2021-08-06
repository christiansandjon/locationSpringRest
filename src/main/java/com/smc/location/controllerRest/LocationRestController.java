package com.smc.location.controllerRest;

import com.smc.location.model.Location;
import com.smc.location.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationRestController {

    @Autowired
    LocationService service;

    @GetMapping
    public List<Location> getAllLocations(){
        return service.findAllLocation();
    }

    @PostMapping
    public Optional<Location> addLocation(@RequestBody Location location) {
        return service.addLocation(location);
    }

    @PutMapping
    public Optional<Location> updateLocation(@RequestBody Location location) {
        return service.updateLocation(location);
    }

    @GetMapping("/{id}")
    public Optional<Location> getLocationById(@PathVariable("id") Long id) {
        return service.findLocationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
         service.deleteLocationById(id);
    }




}
