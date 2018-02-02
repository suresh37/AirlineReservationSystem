package com.ars.service;

import com.ars.dto.Booking;
import com.ars.exception.AirlineReservationException;

public interface IBookingService 
{
 public int addBookingDetails(Booking book) throws AirlineReservationException;

 public Booking getBookingDetails(int bookingId) throws AirlineReservationException;

 public void updateBookingDetails(Booking book) throws AirlineReservationException;

 public Booking removeBookingDetails(int bookingId) throws AirlineReservationException;



}
