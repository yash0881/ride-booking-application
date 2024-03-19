package com.ridebookingapplication.ridebookingapplication.vehicleConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;


    @PostMapping("/create")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.addVehicle(vehicle);
    }



}
