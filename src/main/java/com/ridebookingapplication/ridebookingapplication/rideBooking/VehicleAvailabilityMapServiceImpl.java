package com.ridebookingapplication.ridebookingapplication.rideBooking;

import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleAvailabilityMapServiceImpl implements VehicleAvailabilityMapService{

    @Autowired
    private VehicleAvailabilityMapRepository repository;

    public VehicleAvailabilityMapServiceImpl(VehicleAvailabilityMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public void decreaseCountOfVehicle(VehicleType vehicleType, String city, AreaType areaType) {

        VehicleAvailabilityMapEntity vehicleAvailabilityMap = repository.findByVehicleId_VehicleTypeAndVehicleId_CityAndVehicleId_AreaType(vehicleType, city, areaType);
        int currentCount = vehicleAvailabilityMap.getCount();
        if (currentCount > 0) {
            vehicleAvailabilityMap.setCount(currentCount - 1);
        }
        repository.save(vehicleAvailabilityMap);

    }
}
