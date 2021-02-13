import java.util.Scanner;

/**
 * This class contains table type which is inherited from ReservableItem class
 * 
 * Final Assignment: Reservation System CSS143C
 * @author kraynguyen1
 * @version(3/12/2020)
 * 
 *
 */
public class Table extends ReservableItem{
	protected int numSeat;
	
	/**
	 * Constructor taking in a file and pass to its parent constructor
	 * @param inFile
	 */
	public Table(Scanner inFile) {
		super(inFile);
		
	}
	
	/**
	 * Getter for number of seats
	 * @return int numSeat
	 */
	public int getNumSeats() {
		return numSeat;
	}

}
