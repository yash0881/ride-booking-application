package com.ridebookingapplication.ridebookingapplication.rideBooking;

import jakarta.persistence.EmbeddedId;
import lombok.Data;


@Data
public class Fare {


    @EmbeddedId
    private FareId fareId;
    private float baseFare;
    private float perStopFare;
    private float perKmFare;
    private float peakFare;

}
