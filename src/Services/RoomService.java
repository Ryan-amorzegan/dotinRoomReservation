package Services;

import Data.AppDb;
import Models.Room;
import Services.Interfaces.IRoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomService implements IRoomService
{

    public ArrayList<Room> getRooms(){
        return AppDb.rooms;
    }

    @Override
    public List<Room> getAvailableRooms() {
        return AppDb.rooms
                .stream()
                .filter(x-> x.isAvailable())
                .collect(Collectors.toList());

    }

    @Override
    public String addRoom() {
        Room newRoom = Room.roomFactory();
        if(newRoom == null){
            return "A room with that room number already exists";
        }
        AppDb.rooms.add(newRoom);
        return "Room Added to the database";
    }

    @Override
    public String removeRoom(int roomId) {
        Room room = AppDb.rooms.stream().filter(x-> x.getId() == roomId).findFirst().orElse(null);
        if (room != null){
            AppDb.rooms.remove(room);
            return "Room Removed from the database";
        }else {
            return "There is no room with that index";
        }
    }
}
