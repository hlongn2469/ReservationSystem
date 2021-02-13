/**
 * This class is for the user to reserve cafe table with specifics. Derived from 
 * Reservation class
 * 
 * Final Assignment: Reservation System CSS143C
 * @author kraynguyen1
 * @version(3/12/2020)
 * @author kraynguyen1
 *
 */
public class CafeReservation extends Reservation {
	// instance var
	protected int numSeatsNeeded;
	protected int score;
	protected int numSeats;
	private final int deduct = 10;
	
	public CafeReservation() {
		// no arg constructor
	}
	
	/**
	 * Constructor taking in info of customer name, time slot, and number of
	 * seats needed
	 * @param name
	 * @param timeSlot
	 * @param numSeatsNeeded
	 */
	public CafeReservation(String name, int timeSlot, int numSeatsNeeded) {
		super.customerName = name;
		super.timeSlot = timeSlot;
		this.numSeatsNeeded = numSeatsNeeded;
		//t = new Table();
	}
	
	/**
	 * This method gives a score to each table based on how few extra seats 
	 * are there.
	 * 
	 * @param ReservableItem item
	 * @return int score
	 */
	public int getScore(ReservableItem item) {
		numSeats = item.getSeats();
		score = 0;
		// if table available at given time slot...
		if(item.isAvailable(super.timeSlot)) {
			score += 50;
			
			// if match amount of seats needed... perfect!
			if(this.numSeatsNeeded == item.numSeats) {
				score += 50;
			} 
			
			// deduct points for each extra seat
			if(this.numSeatsNeeded < item.numSeats) {
				for(int i = numSeatsNeeded; i < numSeats; i++) {
					score -= deduct;
				}
			}
			// if the table can't hold enough people.. not a good option
			if(this.numSeatsNeeded > item.numSeats) {
				score = 0;
			}
		}
	
		return score;

	}
	
	/**
	 * Getter for numSeats
	 * @return numSeats int
	 */
	
	public int getNumSeats() {
		return this.numSeats;
	}
	
	/**
	 * Getter for number of seats requested
	 * @return int numSeats needed
	 */
	
	public int getNumSeatsNeeded() {
		return this.numSeatsNeeded;
	}
	
	/**
	 * Getter for time slot 
	 * @return int timeSlot
	 */
	public int getTimeSlot() {
		return this.timeSlot;
	}
}
