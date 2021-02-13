import java.util.ArrayList;
/**
 * This class represents a request to the system to reserve an item for a
 * specific time slot if the reservation is successful it will know what
 * ReservableItem it matched with
 * 
 * Final Assignment: Reservation System CSS143C
 * @author kraynguyen1
 * @version(3/12/2020)
 * @author kraynguyen1
 *
 */
public abstract class Reservation<T> implements Comparable {
	// necessary instance variables
	protected String customerName;
	protected int timeSlot;
	protected Object resourceId;
	protected ArrayList<T> preference;
	private CafeReservation seat;
	
	/**
	 * Set null constructor
	 */
	public Reservation() {
		customerName = null;
		resourceId = null;
	}
	
	/**
	 * Constructor getting info of customer and tie slot
	 * @param customerName
	 * @param timeSlot
	 */
	public Reservation(String customerName, int timeSlot) {
		
		this.customerName = customerName;
		this.timeSlot = timeSlot;
	}
	
	/**
	 * This method to override later getting score 
	 * @param item
	 * @return int score
	 */
	public abstract int getScore(ReservableItem item);
	
	/**
	 * Getter for customer
	 * @return customer name String
	 */
	public String getCustomer() {
		return customerName;
	}
	
	/**
	 * Getter for timeSlot 
	 * @return int timeSlot
	 */
	public int getTime() {
		return timeSlot;
	}
	
	/**
	 * Override toString method providing output info
	 * @return string info
	 */
	public String toString() {
		return "Reservation customer: " + this.customerName + ", timeSlot: " + this.timeSlot + ", Resource ID: " + this.resourceId;
	}
	
	/**
	 * Setter for resource ID
	 * @param obj
	 */
	public void setResourceID(Object obj) {
		resourceId = obj;
	}
	
	/**
	 * This method compares customers name and give a positive value if after,
	 * negative value if before, 0 if equals
	 * 
	 * @param o
	 * @return int result
	 */
	@Override
	public int compareTo(Object o) {
		Reservation other = (Reservation)o;
		int result = 0;
		if(this.getCustomer().compareTo(other.getCustomer()) > 0) {
			result = 1;
		} else if(this.getCustomer().compareTo(other.getCustomer()) < 0) {
			result = -1;
		}
		return result;
	}
	
	/**
	 * Getter for numSeats needed 
	 * @return numSeats needed
	 */
	public int getNumSeatsNeeded() {
		seat = new CafeReservation();
		return seat.getNumSeatsNeeded();
	}

}
