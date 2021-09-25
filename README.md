# ReservationSystems

Develop a general-purpose reservation system, then extend this system to be able to reserve Tables in a Cafe, and to reserve Boats with boat rental company.
From the bottom up, there are classes:

•	Boat, Table  - which each represent an item that can be reserved

•	ReservableItem – an abstract base class for Boats and Tables

•	CafeReservation, BoatReservation – a reservation for the corresponding item, with the time and item that was reserved

•	Reservation – an abstract base class for the reservations

•	ReservationManager – a single class that uses Generics to hold either boat or table reservations.  It does all the real work.

Implemented Merge sort for sorting reservations.

![image](https://user-images.githubusercontent.com/78957509/134765104-d277f594-72b8-4b8b-a2b0-cdba26f4397f.png)

General Flow:
1.	Driver creates a ReservationManager and opens the Scanner for the file.
2.	While there are lines in the input file, the manager is called with addReservable to create a ReservableItem (Boat or Table), which is added to a list in the manager.
3.	The driver creates new trial reservation with the customer name, requested time, and other specifics.
4.	The driver asks the manager to make a reservation.  If it is successful (an item that matches the criteria is available) then the manager fills in the reservation and adds it to the list of reservations. It is only successful if the requested time slot is available.
5.	After all the reservations are made, the reservations are printed out in unsorted, then in sorted order.




