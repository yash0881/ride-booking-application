package com.ridebookingapplication.ridebookingapplication.rideBooking;


import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RideController {



    @Autowired
    RideService rideService;

    @GetMapping("/isAvailable")
    List<RideFareResponse> checkAvailability(@RequestBody RideFareRequest request){

          List<VehicleAvailabilityMapEntity> vehicleAvailabilityMapEntity =  rideService.getAvailableVehicles(request.getCity(), request.getAreaType());

          List<VehicleType> availableVehicles = new ArrayList<>();

          for(VehicleAvailabilityMapEntity entity : vehicleAvailabilityMapEntity){
              availableVehicles.add(entity.getVehicleId().getVehicleType());
          }

        return rideService.getAvailabilityWithFare(availableVehicles, request);
    }



}
