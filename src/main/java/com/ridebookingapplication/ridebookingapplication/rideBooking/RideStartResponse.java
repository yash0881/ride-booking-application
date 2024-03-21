package com.ridebookingapplication.ridebookingapplication.rideBooking;

import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;

public class RideStartResponse {

    private  int rideId;
    private String vehicleNumber;
    private VehicleType vehicleType;

    public RideStartResponse(int rideId, String vehicleNumber, VehicleType vehicleType) {
        this.rideId=rideId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
}
