package Controller;

import Model.Hotel;

import java.util.Collection;
import java.util.Map;

public interface InterfaceAPI {

    Collection<Hotel> findHotelbyName(String name);

    Collection<Hotel> findHotelbyCity(String city);

    void bookRoom(long roomId, long userId, long hotelId);

    void cancelReservation(long roomId, long userId, long hotelId);

    Collection<Hotel> findRoom(Map<String, String> params);
}
