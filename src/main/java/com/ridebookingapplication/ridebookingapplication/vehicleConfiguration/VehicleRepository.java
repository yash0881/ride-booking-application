package com.ridebookingapplication.ridebookingapplication.vehicleConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, VehicleId> {
}
