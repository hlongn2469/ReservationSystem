# ReservationSystems

Develop a general-purpose reservation system, then extend this system to be able to reserve Tables in a Cafe, and to reserve Boats with boat rental company.
From the bottom up, there are classes:

•	Boat, Table  - which each represent an item that can be reserved

•	ReservableItem – an abstract base class for Boats and Tables

•	CafeReservation, BoatReservation – a reservation for the corresponding item, with the time and item that was reserved

•	Reservation – an abstract base class for the reservations

•	ReservationManager – a single class that uses Generics to hold either boat or table reservations.  It does all the real work.

Implemented Merge sort for sorting reservations.


