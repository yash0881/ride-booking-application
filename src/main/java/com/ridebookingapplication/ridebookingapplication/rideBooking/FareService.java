package com.ridebookingapplication.ridebookingapplication.rideBooking;

import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;

import java.util.List;

public interface FareService {

    List<FareEntity> getFare(VehicleType vehicleType, AreaType areaType);
}
