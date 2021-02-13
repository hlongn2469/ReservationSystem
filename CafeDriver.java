/*
 * Reservation System homework
 * CSS143
 * Lesley Kalmin
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Driver for Restaurant Reservations
 */
public class CafeDriver {

	public static void main(String[] args) {
		ReservationManager manager = new ReservationManager();
		try {

			Scanner scanner = new Scanner(new FileInputStream("tableFile.txt"));
			
			while (scanner.hasNext())
			{				
				manager.addReservable(new Table(scanner));				
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			System.exit(0);
		}
		//manager.printItems();  // debugging code, prints list of Tables
		
		CafeReservation r1 = new CafeReservation("Chen family", 3, 2 );
		manager.makeReservation(r1);
		CafeReservation r2 = new CafeReservation( "Singh party", 4, 8);
		manager.makeReservation(r2);
		r2 = new CafeReservation("Kal", 4, 8);
		manager.makeReservation(r2);
		r2 = new CafeReservation("Business1", 4, 8);
		manager.makeReservation(r2);
		CafeReservation r3 = new CafeReservation( "Newmans", 2, 2);
		manager.makeReservation(r3);
	
		r2 = new CafeReservation("TooBig", 4, 11);
		manager.makeReservation(r2);
		r2 = new CafeReservation("Party5", 4, 10);
		manager.makeReservation(r2);
		r3 = new CafeReservation("Party6", 4, 10);
		manager.makeReservation(r3);
		r3 = new CafeReservation("Overflow", 4, 10);
		manager.makeReservation(r3);
		
		System.out.println("Listing of reservations:");
		System.out.println(manager);
		
		System.out.println("\nSorted reservations");
		manager.sortReservations();
		System.out.println(manager);
	}
	

}
