package com.upgrad.VehicleBookingService.repository;

import com.upgrad.VehicleBookingService.model.Booking;

import java.util.List;

public interface BookingRepo {
        Booking getBookingDetails(int bookingId);
        List<Booking> getAllBookings();
        Booking saveBookingDetails(Booking booking);
}
