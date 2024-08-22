package Services.Interfaces;

import Models.*;

import java.util.List;

public interface IOrderService
{
    String makeAnOrder(Client client, int roomId);

    String acceptOrder(int roomId);
    String declineOrder(int roomId);

    List<Order> getOrders();
    List<Order> getUnregisteredReservations(Client client);
    List<Order> getRegisteredReservations(Client client);
    String deleteOrder(Client client, int orderId);
}
