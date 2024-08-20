# Meeting Room Reservation
## Our Purpose
in this project we want to make a meeting room reservation system. this project is going to make the reservation much
easier than it looks. 

---
## Function of the Project

The **Meeting Room Reservation System** is designed to manage the process of reserving and utilizing meeting rooms within an organization. The primary function of this project is to provide an efficient, console interface for employees to book, modify, and cancel meeting room reservations. This system will help avoid conflicts, optimize room utilization, and ensure that meetings are scheduled with all necessary resources available.

#### Key Objectives:
1. **Room Availability Management**: The system will maintain an up-to-date schedule of all available meeting rooms, allowing users to view and select rooms based on their availability.

2. **Reservation and Booking**: Users will be able to book meeting rooms for specific dates and times, specifying additional requirements like room capacity, equipment needed (e.g., projector, video conferencing), and special arrangements.

3. **Conflict Resolution**: The system will automatically detect and prevent double bookings or scheduling conflicts, ensuring that no two meetings overlap in the same room.

4. **Modification and Cancellation**: Users will have the ability to modify or cancel their reservations, with the system automatically updating the room's availability status.

5. **Notifications and Reminders**: The system can send automated notifications and reminders to users about upcoming meetings, changes in reservations, or other relevant updates.

6. **Reporting and Analytics**: Administrators will have access to reports and analytics on room usage, helping optimize resource allocation and identify patterns in room utilization.

#### Benefits:
- **Efficiency**: Simplifies the process of finding and booking meeting rooms, saving time for employees.
- **Resource Optimization**: Ensures that rooms are utilized effectively, reducing instances of unused spaces or scheduling conflicts.
- **Transparency**: Provides a clear and accessible overview of room availability and usage, enhancing communication within the organization.
- **Flexibility**: Offers the ability to modify bookings easily, accommodating changes in meeting schedules.

---
# Structure of the Project


The workspace contains several folders, but all the files are put in by default:

-   `src` this file contains all of our packages.

in this folder, there are packages which the files divided based on their functionality

-   `Data` folder consists of a file which is going to populate the database with default values
-   `Models` folder consists of files to define the entities which is needed through the implementation.
    *   `Person` class refers to our superclass which every other class inherits from it. this class is used for 
registering and including every other entities like *Admin*, *Client*, and *Officer*. 
    *   `Client` class which refers to an entity responsible for performing specific tasks. these tasks will be mentioned later in this file.
    *   `Admin` class which refers to an entity responsible for performing specific tasks. these tasks will be mentioned later in this file.
    *   `Officer` class which refers to an entity responsible for performing specific tasks. these tasks will be mentioned later in this file.
    *   `Order` class is an entity which handles all the things related to the order. in this class, we assign each room to every client who wanted to join a room.
    *   `Room` class is the defining class of the entity with this name.
-   `Services` folder consists of three main classes together with some interfaces. 
    *   `AccountService` class implements the <u>IAccountService</u> interface. in this class, the first checking of the user is being done. 
         > checking the username and password
    *   `OrderService` class implements the <u>IOrderService</u>
         > Creating an order
    
         > Accepting an order
    
         > Declining an order
   
         > Deleting an order
    *    `RoomService` class implements the <u>IRoomService</u>
         > Adding a Room
   
         > Removing a Room
         
         > Getting All the Available Rooms
-   `App` class is responsible for printing the start menu and direct every user to its page. 
---
# Working With Our Code

in order to work with our code, you can simply clone our code by executing this command:

1. Clone the repository to your local machine:
   ```
   git clone https://github.com/Ryan-amorzegan/dotinRoomReservation.git
   ```

2. Navigate to the project directory:
   ```
   cd dotinRoomReservation
   ```

3. Compile the `Main.java` file using `javac`:
   ```
   javac Main.java
   ```

4. Run the application by executing the compiled `Main` class:
   ```
   java Main
   ```
---
# The Requirements

we did our best to implement our approach with the requirements below.

| User                                 | Officer                               | Admin                                      |
|--------------------------------------|---------------------------------------|--------------------------------------------|
| Watching the list of available rooms | watching the list of reserve requests | Watching the list of available rooms       |
| Reserving the rooms                  | Accepting or Declining a Request      | Adding rooms to the list of the rooms      |
| Checking the process of reservation  |                                       | Deleting a room from the list of the rooms |

