package com.smc.location.controller;

import com.smc.location.model.Location;
import com.smc.location.service.interfaces.LocationService;
import com.smc.location.utility.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    LocationService service;
    @Autowired
    EmailUtil emailUtil;

    @RequestMapping("/createLocation")
    public String createLocation() {
        return "createLocation";
    }

    @RequestMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Optional<Location> locationSaved = service.addLocation(location);
        String msg = "Location saved with id: " + locationSaved.get().getId();
        modelMap.addAttribute("msg", msg);
        emailUtil.sendEmail("smc.location.spring@gmail.com","location saved","location is saved in the email good!");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = service.findAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocations(@RequestParam("id") long id, ModelMap modelMap) {
        Location location = new Location();
        location.setId(id);
        service.deleteLocation(location);
        List<Location> locations = service.findAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/updateLocation")
    public String updateLocation(@RequestParam("id") Long id, ModelMap modelMap) {
        Optional<Location> location = service.findLocationById(id);
        modelMap.addAttribute("location", location.get());
        return "updateLocation";
    }
}
