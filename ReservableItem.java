import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents an item that can be reserved
 * 
 * Final Assignment: Reservation System CSS143C
 * 
 * @author kraynguyen1
 * @version(3/12/2020)
 *
 */
public abstract class ReservableItem {
	
	// false means time available
	protected boolean timeSlots[] = new boolean[10];
	private final int time = 10;
	protected String id;
	protected int numSeats;
	
	/** 
	 * Consrcutor setting timeSlot to be available
	 */
	public ReservableItem() {
		for(int i = 0; i < time;i++) {
			timeSlots[i] = false;
		}
	}
	
	/**
	 * Constructor receiving file input and set up ids and seats 
	 * @param inputFile
	 */
	public ReservableItem(Scanner inputFile) {
		id = inputFile.next();
		if(inputFile.hasNextInt()) {
			numSeats = inputFile.nextInt();
		}
	}
	
	/**
	 * Getter for id (ie table?)
	 * @return id String
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * This method check if requested time slot is available or not
	 * @param t
	 * @return true if available, false if not
	 */
	public boolean isAvailable(int t) {
		boolean retVal = false;
		if(timeSlots[t] == false) {
			retVal = true;
		} else {
			retVal = false;
		}
		return retVal;
	}
	
	/**
	 * THis method reserves the time slot at given time
	 * @param t
	 * 
	 * @precondition: timeSlot array is initialized
	 * @poscondition: time slot is mark as taken
	 */
	public void reserveTime(int t) {
		timeSlots[t] = true;
	}
	
	/**
	 * Getter for seats 
	 * @return int numSeats
	 */
	public int getSeats() {
		return this.numSeats;
	}
	
	/**
	 * Override toString method given only ID type
	 */
	public String toString() {
		return id;
	}
}
