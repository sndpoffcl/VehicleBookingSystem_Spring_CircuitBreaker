package com.upgrad.VehicleBookingService.repository;

import com.upgrad.VehicleBookingService.model.Booking;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class BookingRepoImpl implements BookingRepo{

    private static HashMap<Integer,Booking> bookingData = new HashMap<>();

    @PostConstruct
    private void addBooking() {
        bookingData.put(1, new Booking(1,"Ram", 10,2));
        bookingData.put(2, new Booking(2,"Mohan", 11,1));
        bookingData.put(3, new Booking(3,"Krishan", 12,4));
    }


    @Override
    public Booking getBookingDetails(int bookingId) {
        return bookingData.get(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        Collection<Booking> bookingCollection = bookingData.values();
        Iterator<Booking> bookingIterator = bookingCollection.iterator();
        List<Booking> booking = new ArrayList<>();
        while(bookingIterator.hasNext()){
            booking.add(bookingIterator.next());
        }
        return booking;
    }

    @Override
    public Booking saveBookingDetails(Booking booking) {
        bookingData.put(booking.getBookingId(), booking);
        return booking;
    }
}
