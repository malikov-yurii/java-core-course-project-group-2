package main.controller;

import main.model.Hotel;
import main.model.Room;

import java.util.Collection;
import java.util.Map;

public interface InterfaceAPI {

    Collection<Hotel> findHotelbyName(String name);

    Collection<Hotel> findHotelbyCity(String city);

    void bookRoom(long roomId, long userId, long hotelId)  throws AlreadyReservedException, NotFoundException ;

    void cancelReservation(long roomId, long userId, long hotelId)throws AuthorisationException, AlreadyReservedException, NotFoundException;

    Collection<Room> findRoom(Map<String, String> params);

    public class AlreadyReservedException extends Exception {
        public AlreadyReservedException(String message){
            super(message);
        }
    }
    public class AuthorisationException extends Exception {
        public AuthorisationException(String message){
            super(message);
        }
    }

    public class NotFoundException extends Exception {
        public NotFoundException(String message){
            super(message);
        }
    }

}
