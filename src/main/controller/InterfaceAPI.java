package main.controller;

import main.model.Hotel;
import main.model.Room;

import java.util.Collection;
import java.util.Map;

public interface InterfaceAPI {

    Collection<Hotel> findHotelByName(String name);

    Collection<Hotel> findHotelByCity(String city);

    void bookRoom(long roomId, long userId, long hotelId) throws NotFoundException;

    void cancelReservation(long roomId, long userId, long hotelId) throws AuthorisationException, NotFoundException;

    Collection<Room> findRoom(Map<String, String> params);

    class AuthorisationException extends Exception {
        AuthorisationException(String message) {
            super(message);
        }
    }

    class NotFoundException extends Exception {
        NotFoundException(String message) {
            super(message);
        }
    }
}