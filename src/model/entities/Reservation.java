package model.entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exeption.DomainException;

import java.text.SimpleDateFormat;

public class Reservation {

	protected Integer roomNumber;
	protected Date checkIn;
	protected Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	
	public String toString() {
		return "Room "
				+roomNumber
				+", check-in: "
				+sdf.format(checkIn)
				+", check-out: "
				+sdf.format(checkOut)
				+", "
				+duration()
				+" nights";
	}
}