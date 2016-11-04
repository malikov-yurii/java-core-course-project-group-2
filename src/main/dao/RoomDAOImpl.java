package main.dao;

import main.model.Room;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomDAOImpl extends AbstractDAOImpl<Room> {

    private static RoomDAOImpl singletonInstance;

    private RoomDAOImpl(){}

    public static void initialize(Collection<Room> collection){
        if (singletonInstance == null) {
            singletonInstance = new RoomDAOImpl();
            singletonInstance.setCollection(collection);
        }
    }

    public static RoomDAOImpl getInstance(){
        return singletonInstance;
    }

    public static Collection<Room> getRooms() {
        return singletonInstance.getCollection();
    }

    public static Collection<Room> getRoomByPrice(double price){
        Collection<Room> result;
        result = getRooms()
                .stream()
                .filter(room -> room.getPrice() == price)
                .collect(Collectors.toSet());
        return result;
    }

    public static Collection<Room> getRoomByPersons(double persons){
        Collection<Room> result;
        result = getRooms()
                .stream()
                .filter(room -> room.getPersons() == persons)
                .collect(Collectors.toSet());
        return result;
    }

    public static Collection<Room> getRoomByHotelId(double hotelId){
        Collection<Room> result;
        result = getRooms()
                .stream()
                .filter(room -> room.getHotelId() == hotelId)
                .collect(Collectors.toSet());
        return result;
    }

    public static Collection<Room> getRoomByRoomId(double roomId){
        Collection<Room> result;
        result = getRooms()
                .stream()
                .filter(room -> room.getId() == roomId)
                .collect(Collectors.toSet());
        return result;
    }
}
