
package com.ridebookingapplication.ridebookingapplication.vehicleConfiguration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
public class VehicleServiceImpl implements VehicleService {


    @Autowired
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public VehicleEntity getVehicleNumber(VehicleType vehicleType, String city, AreaType areaType) {
        return vehicleRepository.findByVehicleTypeAndCityAndAreaType(vehicleType,city, areaType);
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = new VehicleEntity();

        VehicleId vehicleId = new VehicleId();
        vehicleId.setVehicleNumber(vehicle.getVehicleNumber());
        vehicleId.setVehicleType(vehicle.getVehicleType());
        vehicleId.setCity(vehicle.getCity());
        vehicleId.setAreaType(vehicle.getAreaType());

        vehicleEntity.setVehicleId(vehicleId);

        vehicleEntity.setIsAvailable(vehicle.getIsAvailable());
        vehicleEntity.setCreatedAt(LocalDateTime.now());
        vehicleEntity.setUpdatedAt(LocalDateTime.now());

        VehicleEntity savedEntity = vehicleRepository.save(vehicleEntity);

        return new Vehicle(savedEntity.getVehicleId().getVehicleNumber(), savedEntity.getVehicleId().getVehicleType(), savedEntity.getVehicleId().getCity(), savedEntity.getVehicleId().getAreaType(), savedEntity.getIsAvailable(), savedEntity.getCreatedAt(), savedEntity.getUpdatedAt());
    }
}


