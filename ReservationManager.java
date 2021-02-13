import java.util.ArrayList;
/**
 * This class represents a manager that holds a list of Reservable Items
 *  and a list of Reservations.
 * 
 * Final Assignment: Reservation System CSS143C
 * 
 * @author kraynguyen1
 * @version(3/12/2020)
 *
 */
public class ReservationManager<T> {
	// necessary instance variables
	ArrayList<T> reservations = new ArrayList<T>();
	ArrayList<T> reservableItems = new ArrayList<T>();
	private int score;
	private int bestScore;
	private Object item;
	private int index;
	
	/**
	 * Constructor setting index and score to 0
	 */
	public ReservationManager() {
		index = 0;
		score = 0;
		
	}
	
	/**
	 * THis method add item to reservableItems arrayList
	 * @param item
	 * 
	 * @precondition: item passing in is valid and also the reservableItems list
	 */
	@SuppressWarnings("unchecked")
	public void addReservable(ReservableItem item) {
		reservableItems.add((T) item);
	}
	
	/**
	 * This method is in charge of making reservation, giving a succesful 
	 * reservation if good match, or giving a null return for unsuccesful 
	 * reservation
	 * @param trialRes
	 * @return Reservation obj for success or null for failure
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public Object makeReservation(Reservation trialRes){
		Object obj = null;
		bestScore = 0;
		// loop through each item
		for (int i = 0; i < reservableItems.size();i++) {
			// check if item is availaible at requested time
			if(((ReservableItem)reservableItems.get(i)).isAvailable(trialRes.getTime())) {
				if(((ReservableItem)reservableItems.get(i)).numSeats >= trialRes.getNumSeatsNeeded()){
					
					item = (ReservableItem)reservableItems.get(i);
					
					obj = trialRes;
					// get score
					score = trialRes.getScore((ReservableItem)reservableItems.get(i));
					
					// track the best score
						if(score > bestScore) {
							
							index = i;
							bestScore = score;		
							
						}
					
				} else if(trialRes.preference != null) {
					
				}
				
				score = 0; 
			} else if(!((ReservableItem)reservableItems.get(i)).isAvailable(trialRes.getTime())){
				
				if(trialRes.preference == null) {
					obj = null;
					
				}
				
			}
					
		}
		if(obj != null){
			// take the best one and mark time slot as taken 
			((ReservableItem)reservableItems.get(index)).reserveTime(trialRes.getTime());
			obj = reservableItems.get(index);
			trialRes.setResourceID(obj);
			reservations.add((T) trialRes);
		} else {
			trialRes.setResourceID(obj);
			System.out.println("Unsuccessful Reservation: Reservation Customer: " + trialRes.customerName
					+ ", TimeSlot: " + trialRes.getTime() + ", ResourceID: " + trialRes.resourceId);
		}
		return obj;
	}
	
	
	/**
	 * This method uses merge sort to sort the reservation with merge helper method
	 * source: https://www.codexpedia.com/java/java-merge-sort-implementation/
	 * @precondition: reservations list not null
	 * @postcondition: reservation list is sorted
	 */
	public void sortReservations() {
		mergeSort((ArrayList<Reservation>) reservations);
				//swapStrings((ArrayList<Reservation>) reservations, j);

	}
	
	public ArrayList<Reservation> mergeSort(ArrayList<Reservation> res) {
		ArrayList<Reservation> left = new ArrayList<Reservation>();
	    ArrayList<Reservation> right = new ArrayList<Reservation>();
	    int center;
	 
	    if (res.size() == 1) {    
	        return res;
	    } else {
	        center = res.size()/2;
	        // copy the left half of whole into the left.
	        for (int i=0; i<center; i++) {
	                left.add(res.get(i));
	        }
	 
	        //copy the right half of whole into the new arraylist.
	        for (int i=center; i<res.size(); i++) {
	                right.add(res.get(i));
	        }
	 
	        // Sort the left and right halves of the arraylist.
	        left  = mergeSort(left);
	        right = mergeSort(right);
	 
	        // Merge the results back together.
	        merge(left, right, res);
	    }
	    return res;
	}
	
	private void merge(ArrayList<Reservation> left, ArrayList<Reservation> right, ArrayList<Reservation> whole) {
	    int leftIndex = 0;
	    int rightIndex = 0;
	    int wholeIndex = 0;
	 
	    // As long as neither the left nor the right ArrayList has
	    // been used up, keep taking the smaller of left.get(leftIndex)
	    // or right.get(rightIndex) and adding it at both.get(bothIndex).
	    while (leftIndex < left.size() && rightIndex < right.size()) {
	        if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
	            whole.set(wholeIndex, left.get(leftIndex));
	            leftIndex++;
	        } else {
	            whole.set(wholeIndex, right.get(rightIndex));
	            rightIndex++;
	        }
	        wholeIndex++;
	    }
	 
	    ArrayList<Reservation> rest;
	    int restIndex;
	    if (leftIndex >= left.size()) {
	        // The left ArrayList has been use up...
	        rest = right;
	        restIndex = rightIndex;
	    } else {
	        // The right ArrayList has been used up...
	        rest = left;
	        restIndex = leftIndex;
	    }
	 
	    // Copy the rest of whichever ArrayList (left or right) was not used up.
	    for (int i=restIndex; i<rest.size(); i++) {
	        whole.set(wholeIndex, rest.get(i));
	        wholeIndex++;
	    }
	}
	
	/**
	 * Helper method to swap Strings in the array during sorting
	 * @param res
	 * @param j
	 */
	public void swapStrings(ArrayList <Reservation> res, int j) { 
        // code for swapping Strings 
    	 int i = j -1 ;
   	  
         if(res.get(i).compareTo(res.get(j)) > 0){
      	   	Reservation temp = res.get(j);
      	   	res.set(j, res.get(i));
      	   	res.set(i ,temp);
         }
    }
	
	/**
	 * Override to string method to give each reservation info
	 * 
	 * return String info 
	 */
	public String toString() {
		String retVal = "";
		for(int i = 0; i < reservations.size(); i++) {
			retVal += "\n  " + reservations.get(i);
		}
		return retVal;
	}
}



