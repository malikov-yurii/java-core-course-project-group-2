package main.dao;

import main.model.Room;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RoomDAOImpl extends AbstractDAOImpl<Room> {

    private static RoomDAOImpl singletonInstance;

    private RoomDAOImpl() {
    }

    public static void initialize(Collection<Room> collection) {
        if (singletonInstance == null) {
            singletonInstance = new RoomDAOImpl();
            singletonInstance.saveAll(collection);
        }
    }

    public static RoomDAOImpl getInstance() {
        return singletonInstance;
    }

    public Room getRoomByRoomIdAndHotelId(long roomId, long hotelId) {
        return getList()
                .stream()
                .filter(room -> room.getId() == roomId && room.getHotelId() == hotelId)
                .findFirst()
                .orElse(null);
    }

    public Collection<Room> getRoomByParams(Map<String, String> params) throws NumberFormatException {
        Predicate<Room> testByParams = room -> !(params.containsKey("price")
                && Double.parseDouble(params.get("price")) != room.getPrice())
                && !(params.containsKey("persons")
                && Integer.parseInt(params.get("persons")) != room.getPersons())
                && !(params.containsKey("hotelId")
                && Long.parseLong(params.get("hotelId")) != room.getHotelId())
                && !(params.containsKey("roomId")
                && Long.parseLong(params.get("roomId")) != room.getId());
        return getList()
                .stream()
                .filter(testByParams)
                .collect(Collectors.toSet());
    }
}