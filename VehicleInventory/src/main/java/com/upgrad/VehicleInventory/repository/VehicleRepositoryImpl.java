package com.upgrad.VehicleInventory.repository;

import com.upgrad.VehicleInventory.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    private static HashMap<Integer,Vehicle> vehicleData = new HashMap<>();

    @PostConstruct
    private void fillUsers() {
        vehicleData.put(1, new Vehicle(1,"BMW",true));
        vehicleData.put(2, new Vehicle(2,"Maruti",true));
        vehicleData.put(3, new Vehicle(3,"Mercedez",true));
        vehicleData.put(4, new Vehicle(4,"Audi",true));
        vehicleData.put(5, new Vehicle(5,"Tata",true));
        vehicleData.put(6, new Vehicle(6,"Mahindra",true));
    }

    @Override
    public Vehicle getVehicleDetails(int vehicleId) {
       return vehicleData.get(vehicleId);
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        Collection<Vehicle> VehicleCollection = vehicleData.values();
        Iterator<Vehicle> VehicleIterator = VehicleCollection.iterator();
        List<Vehicle> Vehicles = new ArrayList<>();
        while(VehicleIterator.hasNext()){
            Vehicles.add(VehicleIterator.next());
        }
        return Vehicles;
    }

    @Override
    public Vehicle saveVehicleDetails(Vehicle vehicle) {
        vehicleData.put(vehicle.getVehicleId(), vehicle);
        return vehicle;
    }

}
