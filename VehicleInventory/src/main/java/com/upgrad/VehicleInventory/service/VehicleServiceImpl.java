package com.upgrad.VehicleInventory.service;

import com.upgrad.VehicleInventory.entity.Vehicle;
import com.upgrad.VehicleInventory.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle getVehicleDetails(int vehicleId) {
        simulateSlowService();
        return vehicleRepository.getVehicleDetails(vehicleId);
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        simulateSlowService();
        return vehicleRepository.getAllVehicle();
    }

    @Override
    public Vehicle saveVehicleDetails(Vehicle vehicle) {
        return vehicleRepository.saveVehicleDetails(vehicle);
    }



    private void simulateSlowService() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

