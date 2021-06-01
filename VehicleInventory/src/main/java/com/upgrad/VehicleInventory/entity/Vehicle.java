package com.upgrad.VehicleInventory.entity;

import lombok.Data;

@Data
public class Vehicle {
    private int vehicleId;
    private String vehicleName;
    private boolean isAvailable;

    public Vehicle(int vehicleId, String vehicleName, boolean isAvailable) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.isAvailable = isAvailable;
    }
}
