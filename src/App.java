import Data.AppDb;
import Models.*;
import Services.AccountService;
import Services.Interfaces.IAccountService;
import Services.Interfaces.IOrderService;
import Services.Interfaces.IRoomService;
import Services.OrderService;
import Services.RoomService;
import java.util.List;

import static Utilities.Reader.input;

public class App
{
    private Person loggedInUser;
    private final IRoomService roomService;
    private final IOrderService orderService;
    private final IAccountService accountService;

    public App() {
        this.roomService = new RoomService();
        this.orderService = new OrderService();
        this.accountService = new AccountService();
    }

    private int choice;

    public void start(){
        System.out.println("-------------------Menu-------------------");
        if(loggedInUser == null){
            System.out.println("You are not logged in");
        }else {
            System.out.println("Welcome "+loggedInUser.getClass().toString().substring(13)+" "+loggedInUser.getUsername());
        }
        System.out.println("1.Admin Panel");
        System.out.println("2.Officer Panel");
        System.out.println("3.Client Panel");
        System.out.println("4.Register(Only Clients)");
        System.out.println("5.Login(All Roles)");
        System.out.println("6.Logout");
        System.out.println("9.Print All People");
        System.out.println("0.End the App");
        choice = Integer.parseInt(input.nextLine());
        while(choice!= 0){
            switch(choice){
                case 1:AdminPage();break;
                case 2:OfficerPage();break;
                case 3:ClientPage();break;
                case 4:register();break;
                case 5:login();break;
                case 6:logout();break;
                case 9:printAllPeople();break;
                default:{
                    System.out.println("wrong input");
                    start();
                }break;
            }
            start();
        }
    }

    private void AdminPage()
    {
        if(loggedInUser instanceof Admin){
            System.out.println("-----------------AdminPanel-----------------");
            System.out.println("1.See the Rooms");
            System.out.println("2.Add a Room");
            System.out.println("3.Remove a Room");
            System.out.println("0.return to main menu");
            choice = Integer.parseInt(input.nextLine());
            while (choice!= 0){
                switch (choice){
                    case 1: {showRooms(roomService.getRooms());} break;
                    case 2: {addRoom();}break;
                    case 3: {removeRoom();}break;
                    case 0: start(); break;
                    default: System.out.println("Wrong input");break;
                }
                AdminPage();
            }
        }else {
            System.out.println("You are not an Admin");
        }
    }
    private void OfficerPage()
    {
        if(loggedInUser instanceof Officer){
            System.out.println("-----------------OfficerPanel-----------------");
            System.out.println("1.See the Unregistered Orders");
            System.out.println("2.Accept an Order");
            System.out.println("3.Decline an Order");
            System.out.println("0.return to main menu");
            choice = Integer.parseInt(input.nextLine());

            while (choice!= 0){
                switch (choice){
                    case 1: {showOrders(orderService.getOrders());} break;
                    case 2: {acceptOrder();}break;
                    case 3: {declineOrder();}break;
                    case 0: start(); break;
                    default: System.out.println("Wrong input");break;
                }
                OfficerPage();
            }
        }else {
            System.out.println("You are not an Officer");
        }
    }
    private void ClientPage()
    {
        if(loggedInUser instanceof Client){
            System.out.println("-----------------ClientPanel-----------------");
            System.out.println("1.See the Available Rooms");
            System.out.println("2.Order a Room");
            System.out.println("3.See Requested Reservations");
            System.out.println("4.Remove Reservation Request");
            System.out.println("5.See Accepted Orders");
            System.out.println("6.Add Balance");
            System.out.println("0.return to main menu");
            choice = Integer.parseInt(input.nextLine());
            while(choice != 0){
                switch (choice){
                    case 1: {showRooms(roomService.getAvailableRooms());} break;
                    case 2: {reserveRoom((Client) loggedInUser);}break;
                    case 3: {showOrders(orderService.getUnregisteredReservations((Client) loggedInUser));} break;
                    case 4: {deleteOrder((Client) loggedInUser);} break;
                    case 5: {showOrders(orderService.getRegisteredReservations((Client) loggedInUser));} break;
                    case 6: {addBalance((Client) loggedInUser);}
                    case 0: start(); break;
                    default: System.out.println("Wrong input");break;
                }
                ClientPage();
            }
        }else {
            System.out.println("You are not a Client");
        }
    }

    private void register(){
        if(loggedInUser == null) {
            System.out.println(accountService.register());
        }else {
            System.out.println("You are already logged in");
        }
    }

    private void login(){
        if(loggedInUser == null){
            System.out.println("Enter username: ");
            String username = input.nextLine();
            System.out.println("Enter password: ");
            String password = input.nextLine();
            Person newLoggedInUser = accountService.login(username,password);
            if(newLoggedInUser != null){
                loggedInUser = newLoggedInUser;
            }
        }else {
            System.out.println("You are already logged in");
        }
    }

    public void showRooms(List<Room> rooms){
        for (Room room: rooms
             ) {
            System.out.println(room);
        }
    }

    public void addRoom(){

        System.out.println(roomService.addRoom());
    }

    public void removeRoom(){
        System.out.println("Enter id of the room that you want to remove: ");
        int roomId = Integer.parseInt(input.nextLine());
        System.out.println(roomService.removeRoom(roomId));
    }

    public void showOrders(List<Order> orders){
        for (Order order: orders) {
            System.out.println(order);
        }
    }

    public void acceptOrder(){
        System.out.println("Enter the order you want to accept: ");
        int orderId = Integer.parseInt(input.nextLine());
        System.out.println(orderService.acceptOrder(orderId));
    }
    public void declineOrder(){
        System.out.println("Enter the order you want to decline: ");
        int orderId = Integer.parseInt(input.nextLine());
        System.out.println(orderService.declineOrder(orderId));
    }

    public void reserveRoom(Client client){
        System.out.println("Enter the room id you want to reserve");
        int roomId = Integer.parseInt(input.nextLine());
        System.out.println(orderService.makeAnOrder(client, roomId));
    }

    public void addBalance(Client client){
        System.out.println("Enter the amount: ");
        int balance = Integer.parseInt(input.nextLine());
        client.setBalance((client.getBalance()+balance));
        System.out.println(balance+" added to your balance user: "+client.getUsername());
    }

    public void printAllPeople(){
        for (Person person: AppDb.people
             ) {
            System.out.println(person.toString());
        }
        start();
    }

    public void deleteOrder(Client client){
        System.out.println("enter id of the order you want to delete: ");
        int orderId = Integer.parseInt(input.nextLine());
        orderService.deleteOrder(client , orderId);
    }

    public void logout(){
        loggedInUser = null;
    }
}
