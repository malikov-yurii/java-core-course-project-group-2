package main.dao;

import main.model.Room;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomDAOImpl extends AbstractDAOImpl<Room> {

    private static RoomDAOImpl singletonInstance;

    private RoomDAOImpl() {
    }

    public static void initialize(Collection<Room> collection){
        if (singletonInstance == null) {
            singletonInstance = new RoomDAOImpl();
            singletonInstance.saveAll(collection);
        }
    }

    public static RoomDAOImpl getInstance() {
        return singletonInstance;
    }

    public Set<Room> getRoomByPrice(double price) {
        return getList()
                .stream()
                .filter(room -> room.getPrice() == price)
                .collect(Collectors.toSet());
    }

    public Set<Room> getRoomByPersons(double persons) {
        return getList()
                .stream()
                .filter(room -> room.getPersons() == persons)
                .collect(Collectors.toSet());
    }

    public Set<Room> getRoomByHotelId(double hotelId) {
        return getList()
                .stream()
                .filter(room -> room.getHotelId() == hotelId)
                .collect(Collectors.toSet());
    }

    public Set<Room> getRoomByRoomId(double roomId) {
        return getList()
                .stream()
                .filter(room -> room.getId() == roomId)
                .collect(Collectors.toSet());
    }
}
