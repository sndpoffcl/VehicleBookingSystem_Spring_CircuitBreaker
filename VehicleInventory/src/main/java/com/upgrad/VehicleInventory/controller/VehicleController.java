package com.upgrad.VehicleInventory.controller;

import com.upgrad.VehicleInventory.entity.Vehicle;
import com.upgrad.VehicleInventory.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicle")
    public ResponseEntity getAllVehicles(){
        List<Vehicle> Vehicles = vehicleService.getAllVehicle();
        return ResponseEntity.ok(Vehicles);
    }


    @GetMapping("/vehicle/{id}")
    public ResponseEntity getVehicle(@PathVariable("id") int vehicleId){
        Vehicle vehicle = vehicleService.getVehicleDetails(vehicleId);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/vehicleAvailable/{id}")
    public ResponseEntity getVehicleAvailability(@PathVariable("id") int vehicleId){
        Vehicle vehicle = vehicleService.getVehicleDetails(vehicleId);
        if(vehicle.isAvailable()){
            return ResponseEntity.ok(vehicle);
        }else{
            return ResponseEntity.ok(null);
        }

    }

    @PostMapping("/vehicle")
    public ResponseEntity acceptVehicleDetails(@RequestBody Vehicle vehicle){
        Vehicle savedVehicle = vehicleService.saveVehicleDetails(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }
}
