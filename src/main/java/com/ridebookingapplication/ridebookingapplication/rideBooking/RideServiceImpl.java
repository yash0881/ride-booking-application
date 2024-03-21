package com.ridebookingapplication.ridebookingapplication.rideBooking;


import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleEntity;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class RideServiceImpl implements RideService {


    @Autowired
    private final VehicleAvailabilityMapRepository repository;


    @Autowired
    private final RideRepository rideRepository;
    @Autowired
    private final FareService fareService;

    @Autowired
    private VehicleService vehicleService;


    @Autowired
    private VehicleAvailabilityMapService vehicleAvailabilityMapService;

    @Autowired
    public RideServiceImpl(VehicleAvailabilityMapRepository repository, RideRepository rideRepository, FareService fareService, VehicleService vehicleService, VehicleAvailabilityMapService vehicleAvailabilityMapService) {
        this.repository = repository;
        this.rideRepository = rideRepository;
        this.fareService = fareService;
        this.vehicleService = vehicleService;
        this.vehicleAvailabilityMapService = vehicleAvailabilityMapService;
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
                FareEntity fareEntity = fare.get(0);
                double totalFare = calculateTotalFare(fareEntity, request.getDistance(), request.getStops(), request.getIsPeak());
                RideFareResponse rideFareResponse = new RideFareResponse(vehicle, totalFare);
                rideFareResponses.add(rideFareResponse);
            }
        }
        return rideFareResponses;
    }

    @Override
    public RideStartResponse startRide(RideStartRequest request) {
        VehicleEntity vehicleEntity = vehicleService.getVehicleNumber(request.getVehicleType(),request.getCity(),request.getAreaType());
        String vehicleNumber = vehicleEntity.getVehicleId().getVehicleNumber();
        vehicleAvailabilityMapService.decreaseCountOfVehicle(request.getVehicleType(), request.getCity(), request.getAreaType());
        RideEntity rideEntity = addDetailsToRideTable(request, vehicleNumber);
        RideStartResponse rideStartResponse = new RideStartResponse(rideEntity.getRideId(), rideEntity.getVehicleNumber(), rideEntity.getVehicleType());
        return rideStartResponse;
    }


    public RideEntity addDetailsToRideTable(RideStartRequest request, String vehicleNumber){

        RideEntity rideEntity = new RideEntity();

        rideEntity.setUserId(request.getUserId());
        rideEntity.setDistance(request.getDistance());
        rideEntity.setStops(request.getStops());
        rideEntity.setVehicleNumber(vehicleNumber);
        rideEntity.setVehicleType(request.getVehicleType());
        rideEntity.setAreaType(request.getAreaType());
        rideEntity.setCity(request.getCity());
        rideEntity.setPeak(request.isPeak());
        rideEntity.setTotalFare(request.getTotalFare());

        return rideRepository.save(rideEntity);
    }


    public double calculateTotalFare(FareEntity fare, float distance, int extraStops, boolean peakHours) {
        double baseFare = fare.getBaseFare();
        double farePerKm = fare.getPerKmFare();
        return baseFare + (distance * farePerKm) + (extraStops * fare.getPerStopFare() + (peakHours ? fare.getPeakFare() : 0));
    }
}
