package com.ridebookingapplication.ridebookingapplication.rideBooking;

import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;

public interface VehicleAvailabilityMapService {
    void decreaseCountOfVehicle(VehicleType vehicleType, String city, AreaType areaType);
}
