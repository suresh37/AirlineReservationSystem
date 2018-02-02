package com.ars.dto;

public class Booking {

	private int bookingId;
	private String emailId;
	private int no_of_passengers;
	private String classType;
	private double totalFare;
	private int seatNo;
	private String creditCardInfo;
	private String srcCity;
	private String destCity;
	
	public Booking() 
	{
		
	}
    
	public Booking(String emailId, int no_of_passengers, String classType,
			String creditCardInfo, String srcCity, String destCity) {
		super();
		this.emailId = emailId;
		this.no_of_passengers = no_of_passengers;
		this.classType = classType;
		this.creditCardInfo = creditCardInfo;
		this.srcCity = srcCity;
		this.destCity = destCity;
	}

	public Booking(String emailId, int no_of_passengers, String classType,
			double totalFare, int seatNo, String creditCardInfo,
			String srcCity, String destCity) {
		super();
		this.emailId = emailId;
		this.no_of_passengers = no_of_passengers;
		this.classType = classType;
		this.totalFare = totalFare;
		this.seatNo = seatNo;
		this.creditCardInfo = creditCardInfo;
		this.srcCity = srcCity;
		this.destCity = destCity;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getNo_of_passengers() {
		return no_of_passengers;
	}

	public void setNo_of_passengers(int no_of_passengers) {
		this.no_of_passengers = no_of_passengers;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public String getSrcCity() {
		return srcCity;
	}

	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", emailId=" + emailId
				+ ", no_of_passengers=" + no_of_passengers + ", classType="
				+ classType + ", totalFare=" + totalFare + ", seatNo=" + seatNo
				+ ", creditCardInfo=" + creditCardInfo + ", srcCity=" + srcCity
				+ ", destCity=" + destCity + "]";
	}
   
}
