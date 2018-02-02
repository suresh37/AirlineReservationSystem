package com.ars.service;

import com.ars.dao.BookingDAOImpl;
import com.ars.dao.IBookingDAO;
import com.ars.dto.Booking;
import com.ars.exception.AirlineReservationException;

public class BookingServiceImpl implements IBookingService {

	private IBookingDAO bookingDAO = null;
	public BookingServiceImpl()
	{
		bookingDAO = new BookingDAOImpl();
	}

	@Override
	public int addBookingDetails(Booking book)
			throws AirlineReservationException {
		
		int ticketPrice;
		
		if(book.getClassType().equalsIgnoreCase("business"))
			ticketPrice = 4000;
		else
			ticketPrice = 2500;
		double total = book.getNo_of_passengers()*ticketPrice;
		book.setTotalFare(total);
		
		return bookingDAO.addBookingDetails(book);
	}

	@Override
	public Booking getBookingDetails(int bookingId)
			throws AirlineReservationException {
		
		return bookingDAO.getBookingDetails(bookingId);
	}

	@Override
	public void updateBookingDetails(Booking book)
			throws AirlineReservationException {
		
		bookingDAO.updateBookingDetails(book);
	}

	@Override
	public Booking removeBookingDetails(int bookingId)
			throws AirlineReservationException {
		
		return bookingDAO.removeBookingDetails(bookingId);
	}

}
