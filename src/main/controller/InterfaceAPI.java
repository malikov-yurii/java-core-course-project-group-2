package main.controller;

import main.model.Hotel;
import main.model.Room;

import java.util.Collection;
import java.util.Map;

public interface InterfaceAPI {

    Collection<Hotel> findHotelbyName(String name);

    Collection<Hotel> findHotelbyCity(String city);

    void bookRoom(long roomId, long userId, long hotelId);

    void cancelReservation(long roomId, long userId, long hotelId);

    Collection<Room> findRoom(Map<String, String> params);
}
