package com.ridebookingapplication.ridebookingapplication.rideBooking;


import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class RideServiceImpl implements RideService {

    private final VehicleAvailabilityMapRepository repository;
    private final FareService fareService;

    @Autowired
    public RideServiceImpl(VehicleAvailabilityMapRepository repository, FareService fareService) {
        this.repository = repository;
        this.fareService = fareService;
    }

    @Override
    public List<VehicleAvailabilityMapEntity> getAvailableVehicles(String city, AreaType areaType) {
         return repository.findByVehicleId_CityAndVehicleId_AreaType(city, areaType);
    }

    @Override
    public List<RideFareResponse> getAvailabilityWithFare(List<VehicleType> availableVehicles, RideFareRequest request) {
        List<RideFareResponse> rideFareResponses = new ArrayList<>();
        for (VehicleType vehicle : availableVehicles) {
            List<FareEntity> fare = fareService.getFare(vehicle, request.getAreaType());
            if (!fare.isEmpty()) {
                FareEntity fareEntity = fare.get(0); // Accessing the first element
                double totalFare = calculateTotalFare(fareEntity, request.getDistance(), request.getStops(), request.getIsPeak());
                RideFareResponse rideFareResponse = new RideFareResponse(vehicle, totalFare);
                rideFareResponses.add(rideFareResponse);
            }
        }
        return rideFareResponses;
    }


    private double calculateTotalFare(FareEntity fare, float distance, int extraStops, boolean peakHours) {
        double baseFare = fare.getBaseFare();
        double farePerKm = fare.getPerKmFare();
        return baseFare + (distance * farePerKm) + (extraStops * fare.getPerStopFare() + (peakHours ? fare.getPeakFare() : 0));
    }
}
