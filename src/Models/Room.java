package Models;

import Data.AppDb;

import java.util.ArrayList;

import static Utilities.Reader.input;

public class Room
{
    private static int idInc = 0;
    private int id;
    private int roomNumber;
    private int capacity;
    private int cost;
    private boolean isAvailable;

    public Room() {
    }

    public Room(int capacity, int cost, int roomNumber) {
        setCapacity(capacity);
        setAvailable(true);
        setRoomNumber(roomNumber);
        setCost(cost);
        this.id = idInc;
        idInc++;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean setRoomNumber(int roomNumber) {
        boolean isGood = true;
        ArrayList<Room> rooms = AppDb.rooms;
        for (Room ro:rooms) {
            if(ro.roomNumber == this.roomNumber){
                isGood = false;
                return false;
            }
        }
        if(isGood){
            this.roomNumber = roomNumber;
        }
        return true;
    }

    public static Room roomFactory() {
        Room room = new Room();
        room.id = idInc;
        System.out.println("Enter the room capacity: ");
        room.setCapacity(Integer.parseInt(input.nextLine()));
        System.out.println("Enter the room cost: ");
        room.setCost(Integer.parseInt(input.nextLine()));
        System.out.println("Enter the room number: ");
        room.setRoomNumber(Integer.parseInt(input.nextLine()));
        room.setAvailable(true);
        idInc++;
        if(room.getRoomNumber() != 0){
            return room;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", isAvailable=" + isAvailable +
                ", cost" + cost +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
