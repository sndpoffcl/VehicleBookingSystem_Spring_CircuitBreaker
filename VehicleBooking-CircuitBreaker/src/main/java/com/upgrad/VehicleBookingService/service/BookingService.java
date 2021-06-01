package com.upgrad.VehicleBookingService.service;

import com.upgrad.VehicleBookingService.model.Booking;

import java.util.List;

public interface BookingService {
    Booking getBookingDetails(int bookingId);
    List<Booking> getAllBooking();
    String saveBookingDetails(Booking booking);

}
