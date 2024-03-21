package com.ridebookingapplication.ridebookingapplication.rideBooking;

import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;

import java.util.List;

public interface RideService {

    List<VehicleAvailabilityMapEntity> getAvailableVehicles(String city, AreaType areaType);
    List<RideFareResponse> getAvailabilityWithFare(List<VehicleType> availableVehicles, RideFareRequest request);

    RideStartResponse startRide(RideStartRequest request);
    RideEntity addDetailsToRideTable(RideStartRequest request, String vehicleNumber);
}
