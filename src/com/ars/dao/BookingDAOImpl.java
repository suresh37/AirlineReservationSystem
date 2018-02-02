package com.ars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ars.dto.Booking;
import com.ars.exception.AirlineReservationException;
import com.ars.util.DBUtil;

public class BookingDAOImpl implements IBookingDAO {

	public BookingDAOImpl()
	{ }		
   public int generateBookingId() throws AirlineReservationException
   {
	   int bookingId = 0;
	   try(Connection con = DBUtil.getConnection())
	   {
		   Statement stm = con.createStatement();
		   ResultSet res = stm.executeQuery("select book_id_seq.nextVal from dual");
		   	
		   	if(res.next() == false) //res.next();
		   	{
		   		throw new AirlineReservationException("Could not Generate Booking ID");
		   		
		   	}
		   	bookingId = res.getInt(1); 
	   } 
	   catch(SQLException e) {
		  throw new AirlineReservationException(e);
	  }
	  catch (Exception e) 
	   {
		 throw new AirlineReservationException(e);
	   }
	      
	return bookingId;
	   
   }
	@Override
	public int addBookingDetails(Booking book)
			throws AirlineReservationException
	{
		int bookingId = 0;
		try(Connection con = DBUtil.getConnection())
		{
			book.setBookingId(generateBookingId());
			
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery("select seat_id_seq .nextVal from dual");
			book.setSeatNo(res.getInt(1));
			int i=1;
			while(i < book.getNo_of_passengers()-1)
				stm.execute("select seat_id_seq .nextVal from dual");
			
			PreparedStatement pstm =con.prepareStatement("insert into booking_info values(?,?,?,?,,?,?,?,?)");
		   
		    pstm.setInt( 1, book.getBookingId());
		    pstm.setString( 2, book.getEmailId());
		    pstm.setInt( 3, book.getNo_of_passengers());
		    pstm.setString( 4, book.getClassType());
		    pstm.setDouble( 5, book.getTotalFare());
		    pstm.setInt( 6 , book.getSeatNo());
		    pstm.setString(7 , book.getCreditCardInfo());
		    pstm.setString( 8 , book.getSrcCity());
		    pstm.setString( 9 , book.getDestCity());
		    pstm.execute();
		    
		    bookingId = book.getBookingId();
		}
		catch (Exception e) 
		{
			throw new AirlineReservationException(e);
		}
		
		
		return 0;
	}

	@Override
	public Booking getBookingDetails(int bookingId)
			throws AirlineReservationException {
		
		Booking book = null;
		try(Connection con = DBUtil.getConnection())
		{
	      PreparedStatement pstm = con.prepareStatement("Select * from  BOOKING_INFO where Booking_Id=?");
	      pstm.setInt(1, bookingId);	
			
	      ResultSet res = pstm.executeQuery();
	      if(res.next() == false)
	         throw new AirlineReservationException("No Booking Details Found With Id");
	  
		 book = new Booking();
		 //List<Booking> bookings = new ArrayList<>();
    	 //  while (res.next()) {
		 book.setBookingId(res.getInt(1));
		 book.setEmailId(res.getString(2));
		 book.setNo_of_passengers(res.getInt(3));
		 book.setClassType(res.getString(4));
		 book.setTotalFare(res.getDouble(5));
		 book.setSeatNo(res.getInt(6));
	     book.setCreditCardInfo(res.getString(7));
	     book.setSrcCity(res.getString(8));
	     book.setDestCity(res.getString(9));
	     // bookings.add(book); for list
   	  // }
		} 
		catch (Exception e) 
		{
			throw new AirlineReservationException();
		}
		
		
		return book;
	}

	@Override
	public void updateBookingDetails(Booking book)
			throws AirlineReservationException {
		
		try(Connection con = DBUtil.getConnection())
		{
			PreparedStatement pstm = con.prepareStatement("Update Booking_Info set cust_email=?,no_of_passengers=?,class_type=?,total_fare=?,seat_number=?,CreditCard_info=?,src_city=?,dest_city=?");
		    pstm.setString(1 , book.getEmailId());
		    pstm.setInt( 2 , book.getNo_of_passengers());
		    pstm.setString( 3 , book.getClassType());
		    pstm.setDouble( 4, book.getTotalFare());
		    pstm.setInt( 5 , book.getSeatNo());
		    pstm.setString( 6 , book.getCreditCardInfo());
		    pstm.setString( 7 , book.getSrcCity());
		    pstm.setString( 8 , book.getDestCity());
		} 
		catch (Exception e) 
		{
			throw new AirlineReservationException();
		}
		
		
		//return 0;
	}

	@Override
	public Booking removeBookingDetails(int bookingId)
			throws AirlineReservationException {
		Booking book = null;
		try(Connection con = DBUtil.getConnection())
		{
	     PreparedStatement pstm1 = con.prepareStatement("Select * from BOOKING_INFO where Booking_Id=?");
   	     pstm1.setInt(1, bookingId);
   	     
   	    ResultSet res = pstm1.executeQuery();
	    
	    if(res.next() == false)
		   throw new AirlineReservationException("No Booking Details Found With Id");
	    
	    book = new Booking();
	     book.setBookingId(res.getInt(1));
		 book.setEmailId(res.getString(2));
		 book.setNo_of_passengers(res.getInt(3));
		 book.setClassType(res.getString(4));
		 book.setTotalFare(res.getDouble(5));
		 book.setSeatNo(res.getInt(6));
	     book.setCreditCardInfo(res.getString(7));
	     book.setSrcCity(res.getString(8));
	     book.setDestCity(res.getString(9));
	    
	    PreparedStatement pstm2 = con.prepareStatement("Delete * from BOOKING_INFO where Booking_Id=?");
  	    pstm2.setInt(1, bookingId);
  	     
		} 
		catch (Exception e) 
		{
			throw new AirlineReservationException();
		}
		return book;
	}

}
