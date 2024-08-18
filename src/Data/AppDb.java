package Data;
import Models.*;
import java.util.ArrayList;

public class AppDb
{
    public static ArrayList<Person> people = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();

    public static void SeedDatabase(){
        SeedPeople();
        SeedRooms();
        SeedOrders();
    }

    private static void SeedRooms(){
        rooms.add(new Room(2,100,1));
        rooms.add(new Room(3,140,2));
        rooms.add(new Room(4,180,3));
        rooms.add(new Room(5,220,4));
        rooms.add(new Room(6, 250,5));
        rooms.add(new Room(7, 275,6));
        rooms.add(new Room(8, 300,6));

    }
    private static void SeedPeople(){
        people.add(new Client("client1","1234", 1000));
        people.add(new Client("client2","1234", 1000));
        people.add(new Client("client3","1234", 1000));

        people.add(new Admin("admin1","1234"));
        people.add(new Officer("officer1","1234"));
    }
    private static void SeedOrders(){
        orders.add(new Order((Client) people.get(0), rooms.get(0)));
        orders.add(new Order((Client) people.get(1), rooms.get(2)));
        orders.add(new Order((Client) people.get(2), rooms.get(5)));
    }
}
