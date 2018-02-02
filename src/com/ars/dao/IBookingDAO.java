package com.ars.dao;

import com.ars.dto.Booking;
import com.ars.exception.AirlineReservationException;

public interface IBookingDAO 
{
	 public int addBookingDetails(Booking book) throws AirlineReservationException;

	 public Booking getBookingDetails(int bookingId) throws AirlineReservationException;

	 public void updateBookingDetails(Booking book) throws AirlineReservationException;

	 public Booking removeBookingDetails(int bookingId) throws AirlineReservationException;

}
