package com.ridebookingapplication.ridebookingapplication.rideBooking;


import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideFareResponse {

    private VehicleType vehicleType;
    private double fare;
}
