package Controller;

import Model.Hotel;

import java.util.Collection;
import java.util.Map;

public class InterfaceAPIImpl implements InterfaceAPI {
    @Override
    public Collection<Hotel> findHotelbyName(String name) {
        return null;
    }

    @Override
    public Collection<Hotel> findHotelbyCity(String city) {
        return null;
    }

    @Override
    public void bookRoom(long roomId, long userId, long hotelId) {

    }

    @Override
    public void cancelReservation(long roomId, long userId, long hotelId) {

    }

    @Override
    public Collection<Hotel> findRoom(Map<String, String> params) {
        return null;
    }
}
