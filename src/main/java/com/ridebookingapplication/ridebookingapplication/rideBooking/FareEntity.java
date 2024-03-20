package com.ridebookingapplication.ridebookingapplication.rideBooking;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fare")
public class FareEntity {


    @EmbeddedId
    private FareId fareId;
    private float baseFare;
    private float perStopFare;
    private float perKmFare;
    private float peakFare;

}
