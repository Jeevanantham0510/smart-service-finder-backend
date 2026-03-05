package com.example.local_service_finder.Controller;

import com.example.local_service_finder.Entity.Booking;
import com.example.local_service_finder.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    private final BookingRepository bookingRepository;

    // BOOK SERVICE
    @PostMapping("/book")
    public Booking bookService(@RequestBody Booking booking) {
        booking.setStatus("BOOKED");
        return bookingRepository.save(booking);
    }

    // GET ALL BOOKINGS (ADD THIS METHOD)
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}