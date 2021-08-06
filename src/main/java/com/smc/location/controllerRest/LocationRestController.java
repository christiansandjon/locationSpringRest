package com.smc.location.controllerRest;

import com.smc.location.model.Location;
import com.smc.location.service.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationRestController {

    @Autowired
    LocationService service;

    public List<Location> getAllLocations(){
        return service.findAllLocation();
    }
}
