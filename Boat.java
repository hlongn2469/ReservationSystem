import java.util.Scanner;
/**
 * This class contains boat type which is inherited from ReservableItem class
 * 
 * Final Assignment: Reservation System CSS143C
 * @author kraynguyen1
 * @version(3/12/2020)
 *
 */
public class Boat extends ReservableItem{
	
	/*
	 * Constructor taking in file scanner and placing the file scanner into the super 
	 * constructor's parameter
	 */
	public Boat(Scanner scanner) {
		super(scanner);
	}

}
