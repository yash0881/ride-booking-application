package com.ridebookingapplication.ridebookingapplication.rideBooking;

import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.AreaType;
import com.ridebookingapplication.ridebookingapplication.vehicleConfiguration.VehicleType;

public class RideStartRequest {
    private int userId;
    private int distance;
    private int stops;
    private String city;
    private AreaType areaType;
    private boolean isPeak;
    private VehicleType vehicleType;
    private double totalFare;

    public RideStartRequest() {
    }

    public RideStartRequest(int userId, int distance, int stops, String vehicleNumber, String city, AreaType areaType, boolean isPeak, VehicleType vehicleType, int totalFare) {
        this.userId = userId;
        this.distance = distance;
        this.stops = stops;
        this.city = city;
        this.areaType = areaType;
        this.isPeak = isPeak;
        this.vehicleType = vehicleType;
        this.totalFare = totalFare;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }

    public boolean isPeak() {
        return isPeak;
    }

    public void setPeak(boolean peak) {
        isPeak = peak;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }
}
