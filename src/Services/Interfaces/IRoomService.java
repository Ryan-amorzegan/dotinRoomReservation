package Services.Interfaces;

import Models.Room;

import java.util.ArrayList;
import java.util.List;

public interface IRoomService
{
    ArrayList<Room> getRooms();

    List<Room> getAvailableRooms();

    String addRoom();

    String removeRoom(int roomId);
}
