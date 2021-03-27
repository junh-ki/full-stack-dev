package com.jun.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jun.location.entities.Location;
import com.jun.location.entities.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {
    
    @Autowired
    LocationRepository locationRepository; // If there is a business logic, involving repo is not a good idea. Service should be included in such case
    
    @GetMapping // binds GET with getLocations()
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }
    
}
