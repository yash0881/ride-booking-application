package com.ridebookingapplication.ridebookingapplication.rideBooking;


import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class VehicleId implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private VehicleType vehicleType;

    @Column(length = 50)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private AreaType areaType;

}
