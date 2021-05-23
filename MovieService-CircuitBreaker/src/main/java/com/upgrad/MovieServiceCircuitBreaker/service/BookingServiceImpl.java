package com.upgrad.MovieServiceCircuitBreaker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.upgrad.MovieServiceCircuitBreaker.model.Booking;
import com.upgrad.MovieServiceCircuitBreaker.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public Booking getBookingDetails(int bookingId) {
        return bookingRepo.getBookingDetails(bookingId);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepo.getAllBookings();
    }

    @Override
    @HystrixCommand(fallbackMethod = "defaultBooking")
    public String saveBookingDetails(Booking booking) {
        if(booking != null){
            /** validating customerId as User from UserDetailsService **/
            int customerId  = booking.getCustomerId();
            String url = "http://localhost:9090/v1/uds/customer/" + customerId;
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);
            if(result != null){
                bookingRepo.saveBookingDetails(booking);
                return "Booking was successful with id : " + booking.getBookingId();
            }
        }
        return "Booking was unsuccessful";
    }

    private String defaultBooking(Booking booking) {
        return "Booking : " + booking.getBookingId() +  " was not successful, as we could not validate user details";
    }
}
