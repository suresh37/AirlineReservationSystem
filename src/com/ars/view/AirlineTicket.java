package com.ars.view;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.ars.dto.Booking;
import com.ars.exception.AirlineReservationException;
import com.ars.service.BookingServiceImpl;
import com.ars.service.IBookingService;

public class AirlineTicket 
{

	private IBookingService bookingservice= null;
	
	public AirlineTicket() {
	    bookingservice = new BookingServiceImpl();	
	}
	
	private void menu() 
	{
			Scanner console = new Scanner(System.in);
			System.out.println("******Airline Reservation System Application*****");
			System.out.println("1) Book Air Ticket ");
			System.out.println("2) Get Air Ticket Details ");
			System.out.println("3) Update Air Ticket Details ");
			System.out.println("4) Cancel Air Ticket");
			System.out.println("5) Exit AirLine Application ");
			System.out.println("\nEnter Your Choice: ");
			int choice = console.nextInt();
			operation(choice);
	}


	private void operation(int choice)
	{
		switch(choice)
		{
		case 1: 
			  bookTicket();
			 break;
		case 2: 
			  checkTicket();
			 break;
		case 3: 
			  updateTicket();
			 break;
		case 4: 
			  cancelTicket();
			 break;
		case 5:
			 System.out.println("Thanks for Visiting our Airline Ticket Application!! Good Bye!!");
			 System.exit(0);
			 
	   default:
		     System.out.println("Please Provide Valid Input!!");
		}
	}

	private void cancelTicket() 
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Cancel Air Ticket \nEnter Your Booking Id: ");
		int bookingId = console.nextInt();
	    try 
		{
	       Booking book = bookingservice.removeBookingDetails(bookingId);
	       System.out.println(book);
	       
		} 
		catch (AirlineReservationException e) 
		{
			System.out.println("Something Went Wrong While trying to Cancel Ticket.Reason: "+e.getMessage());
		}
		catch (Exception e) 
		{   //e.printStackTrace();
			System.out.println("Something went Wrong");
		}
	
	
		
	}

	private void updateTicket()
	{
		/*try 
		{
			Product product =productService.getProduct(id);
			
			System.out.println("Current Product Name "+product.getName());
			System.out.println("Do you want to update Name? (yes/no)");
			String reply =console.next();
			
			if(reply.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter New Name: ");
				product.setName(console.next());
			}
			
			System.out.println("Current Product Price "+product.getPrice());
			System.out.println("Do you want to update Price? (yes/no)");
			reply =console.next();
			if(reply.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter New Price: ");
				product.setPrice(console.nextDouble());
			}
			
			System.out.println("Current Product Category "+product.getCategory());
			System.out.println("Do you want to update Category? (yes/no)");
			reply =console.next();
			if(reply.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter New Catgeory: ");
				product.setCategory(console.next());
			}
			
			System.out.println("Current Product Manufacture Date "+product.getManufactureDate());
			System.out.println("Do you want to update Manufacture Date? (yes/no)");
			reply =console.next();
			if(reply.equalsIgnoreCase("yes"))
			{
				System.out.println("Enter New Manufacture Date (dd-MM-yyyy): ");
				//convert string to date
				String date = console.next();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate localDate = LocalDate.parse(date,format);
				Date mDate = java.sql.Date.valueOf(localDate);
				
				product.setManufactureDate(mDate);
				
			}
			productService.updateProduct(product);
			System.out.println("Product Updated successfully");
		}
		catch (ProductManagementSystemException e) 
		{
			System.out.println("Something Went Wrong While trying to update product details.Reason: "+e.getLocalizedMessage());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//System.out.println("Something went Wrong");
		}*/
	
		
	}

	private void checkTicket() 
	{
		Scanner console = new Scanner(System.in);
		System.out.println(" Checking Air Ticket Details \n Enter your Booking Id: ");
		int bookingId = console.nextInt();
	    try 
		{
	    	Booking book = bookingservice.getBookingDetails(bookingId);
		    System.out.println(book);
		} 
		catch (AirlineReservationException e) 
		{
			System.out.println("Something Went Wrong While trying to Check Booking details.Reason: "+e.getMessage());
		}
		catch (Exception e) 
		{   //e.printStackTrace();
			System.out.println("Something went Wrong");
		}
	
	
	}

	private void bookTicket() 
	{
	    Scanner console = new Scanner(System.in);
	    System.out.println(" Booking Air Ticket \nEnter Your Details: ");
	    
	    System.out.println("1) Enter Your E-mail Id: ");
	    String email = console.next();
	    System.out.println("2) Enter No. of Passengers: ");
	    int passengers = console.nextInt();
	    System.out.println("3) Enter Class Type: i)Bussiness ii)Economy iii)Premium Economy iv)First Class ");
	    String classType = console.next();
	    System.out.println("4) Enter Credit Card Info ");
	    String creditcard = console.next();
	    System.out.println("5) Enter Source City: ");
	    String src = console.next();
	    System.out.println("6) Enter Destination City: ");
	    String dest = console.next();
		
	    Booking book = new Booking(email,passengers,classType,creditcard,src,dest);
	 
	    try 
		{
	    	int bookingId = bookingservice.addBookingDetails(book);
	    	System.out.println("Welcome, Your AirTicket Successfully Booked");
	    	System.out.println("Your Booking Id is: "+bookingId);		
		} 
		catch (AirlineReservationException e) 
		{
			System.out.println("Something Went Wrong While trying to add Booking details.Reason: "+e.getMessage());
		}
		catch (Exception e) 
		{   //e.printStackTrace();
			System.out.println("Something went Wrong");
		}
	
	
	
	}

	public static void main(String[] args) 
	{
	  PropertyConfigurator.configure("log4j.properties");
	  
	  AirlineTicket airticket = new AirlineTicket();
	  while(true)
	  {
		airticket.menu();
	  }
	}
}

	