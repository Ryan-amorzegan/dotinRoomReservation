package Services;
import Data.AppDb;
import Models.*;
import Services.Interfaces.IOrderService;
import java.util.List;
import java.util.stream.Collectors;
import static Data.AppDb.orders;

public class OrderService implements IOrderService
{
    @Override
    public String makeAnOrder(Client client,int roomId) {
        Room room = AppDb.rooms.stream().filter(r -> r.getId() == roomId).findFirst().orElse(null);
        if(room != null && room.isAvailable() && client.getBalance() >= room.getCost()){
            Order newOrder = new Order(client, room);
            orders.add(newOrder);
            return "order successfully registered, wait for an officer to accept your order";
        }else {
            return "room id is not valid";
        }
    }

    @Override
    public String acceptOrder(int orderId) {
        Order order = orders.stream().filter(x-> x.getId()==orderId && !x.isRegistered()).findFirst().orElse(null);
        if(order != null && !order.isRegistered()){
            order.setRegistered(true);
            return "order successfully accepted";
        }else {
            return "order is already registered or invalid order id";
        }
    }

    @Override
    public String declineOrder(int orderId) {
        Order order = orders.stream().filter(x-> x.getId()==orderId && !x.isRegistered()).findFirst().orElse(null);
        if(order != null && !order.isRegistered()){
            Client client = order.getClient();
            Room room = order.getRoom();

            room.setAvailable(true);
            client.setBalance(client.getBalance()+order.getRoom().getCost());
            orders.remove(order);
            return "order successfully declined";
        }else {
            return "order is already registered or invalid order id";
        }
    }

    @Override
    public List<Order> getOrders() {
        return orders.stream()
                .filter(x-> !x.isRegistered())
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getUnregisteredReservations(Client client) {
        return AppDb.orders.stream()
                .filter(x-> !x.isRegistered()&& x.getClient() == client)
                .collect(Collectors.toList());

    }

    @Override
    public List<Order> getRegisteredReservations(Client client) {
        return orders.stream()
                .filter(x-> x.getClient() == client && x.isRegistered())
                .collect(Collectors.toList());
    }

    @Override
    public String deleteOrder(Client client, int orderId) {
        Client c = client;
        Order order = orders.stream().filter(x-> x.getClient()== client && x.getId()== orderId && !x.isRegistered()).findFirst().orElse(null);
        if(order != null){
            orders.remove(order);
            return "order removed";
        }
        return "invalid order id";
    }

}
