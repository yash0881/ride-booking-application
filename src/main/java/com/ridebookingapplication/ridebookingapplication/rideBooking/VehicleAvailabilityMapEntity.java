package com.ridebookingapplication.ridebookingapplication.rideBooking;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle_map")
public class VehicleAvailabilityMapEntity {

    @EmbeddedId
    private VehicleId vehicleId;
    private int count;


}
