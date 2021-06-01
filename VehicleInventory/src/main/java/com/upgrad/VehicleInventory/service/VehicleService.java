package com.upgrad.VehicleInventory.service;

import com.upgrad.VehicleInventory.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle getVehicleDetails(int vehicleId);
    List<Vehicle> getAllVehicle();
    Vehicle saveVehicleDetails(Vehicle vehicle);

}
