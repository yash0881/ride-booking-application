package com.ridebookingapplication.ridebookingapplication.vehicleConfiguration;

public interface VehicleService {

    VehicleEntity getVehicleNumber(VehicleType vehicleType, String city, AreaType areaType);


    Vehicle addVehicle(Vehicle vehicle);

}
