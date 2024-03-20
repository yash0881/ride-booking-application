package com.ridebookingapplication.ridebookingapplication.rideBooking;

import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleAvailabilityMapRepository extends JpaRepository<VehicleAvailabilityMapEntity, VehicleId> {
    List<VehicleAvailabilityMapEntity> findByVehicleId_CityAndVehicleId_AreaType(String city, AreaType areaType);
}