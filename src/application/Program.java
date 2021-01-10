package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exeption.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());		
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			Reservation res = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(res);
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn1 = sdf.parse(sc.next());		
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut1 = sdf.parse(sc.next());
			res = new Reservation(roomNumber, checkIn1, checkOut1);
			System.out.println(res);
		}
		catch(ParseException e){	
			System.out.println("Invalid date");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: "+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();
	}
}
