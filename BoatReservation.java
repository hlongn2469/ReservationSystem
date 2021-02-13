import java.util.ArrayList;
/**
 * This class is for the user to reserve specific boat type. Derived from 
 * Reservation class
 * 
 * Final Assignment: Reservation System CSS143C
 * @author kraynguyen1
 * @version(3/12/2020)
 *
 * @param <T>
 */
public class BoatReservation<T> extends Reservation{
	// track score
	private int score;
	
	// deduct if order of preferences decreases
	private int deduct;
	private final int penalty = 10;
	/**
	 * Constructor taking in customer name and time slot 
	 * @param customerName
	 * @param timeSlot
	 */
	public BoatReservation(String customerName, int timeSlot) {
		super.customerName = customerName;
		super.timeSlot = timeSlot;
		preference = new ArrayList<T>();
	}
	
	/**
	 * This method add boat name to the arrayList of preference
	 * @param boatName
	 * 
	 * @precondition: preference arraylist and argument is valid
	 * @postcondition: boat name added to the list
	 */
	public void addBoatPreference(String boatName) {
		preference.add((T) boatName);
	}
	
	/**
	 * This method determines the score of the item from ReservableItem
	 * and give it a score based on the preference list
	 * 
	 * @param ReservableItem item
	 * @return int score
	 */
	@Override
	public int getScore(ReservableItem item) {
		score = 0;
		deduct = 0;
		
		// if item available at time slot...
		if(item.isAvailable(super.timeSlot)) {
			score += 100;
			for(int i = 0; i < preference.size(); i++) {
				// the further down the preference list, the more point deductions
				deduct = i * 2;
				if(((preference).get(i).equals(item.getId()))) {
					score -= deduct;
				// if not found in the list, deduct fixed amount of points
				} else {
					score -= penalty;
				}
			}
		}
		return score;
	}

}
