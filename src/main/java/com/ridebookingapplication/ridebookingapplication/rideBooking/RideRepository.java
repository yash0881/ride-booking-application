package com.ridebookingapplication.ridebookingapplication.rideBooking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<RideEntity, Integer> {
}
