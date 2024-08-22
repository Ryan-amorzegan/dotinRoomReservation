package Models;

import java.util.Calendar;
import java.util.Date;

public class Order
{
    private static int idInc;
    private int id;
    private Client client;
    private Room room;
    private boolean isRegistered;
    private Date orderDate;

    public Order(Client client, Room room) {
        id = idInc;
        this.client = client;
        this.setOrderDate(Calendar.getInstance().getTime());
        client.setBalance((client.getBalance()-room.getCost()));
        room.setAvailable(false);
        this.room = room;
        this.isRegistered = false;
        idInc++;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isRegistered() {
        return isRegistered;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", room=" + room +
                ", isRegistered=" + isRegistered +
                ", orderDate=" + orderDate +
                '}';
    }
}
