package com.upgrad.VehicleBookingService.model;

import lombok.Data;

@Data
public class Booking {
    private int bookingId;
    private String customerName;
    private int customerId;
    private int vehicleId;

    public Booking(int bookingId, String customerName, int customerId, int vehicleId) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
    }
}
