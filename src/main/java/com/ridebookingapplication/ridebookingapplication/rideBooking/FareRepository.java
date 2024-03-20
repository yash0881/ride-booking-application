package com.ridebookingapplication.ridebookingapplication.rideBooking;

import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FareRepository extends JpaRepository<FareEntity, FareId> {
    List<FareEntity> getByFareId_VehicleTypeAndFareId_AreaType(VehicleType vehicleType, AreaType areaType);
}
