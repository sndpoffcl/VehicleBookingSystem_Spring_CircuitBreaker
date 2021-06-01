package com.upgrad.VehicleInventory.repository;

import com.upgrad.VehicleInventory.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Vehicle getVehicleDetails(int vehicleId);
    List<Vehicle> getAllVehicle();
    Vehicle saveVehicleDetails(Vehicle vehicle);

}
