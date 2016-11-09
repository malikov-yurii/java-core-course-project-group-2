package main.controller;

import main.dao.HotelDAOImpl;
import main.dao.RoomDAOImpl;
import main.dao.UserDAOImpl;
import main.model.AuthorizedUser;
import main.model.Hotel;
import main.model.Room;
import main.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;


/**
 * Created by Mykhailo Senchuk on 11/2/2016.
 * <p>
 * <p>
 * takes data from DAO(empty constructor)
 * <p>
 * implements methods:
 * <p>
 * public Collection<Hotel>  findHotelByName(String name)
 * public Collection<Hotel> findHotelByCity(String city)
 * public void bookRoom(long roomId, long userId, long hotelId)
 * public void cancelReservation(long roomId, long userId, long hotelId)
 * public Collection<room> getRoomByParams(Map<String, String> params)
 * <p>
 * supporting methods:
 * private Room searchRoom(long roomId, long hotelId)
 * private User searchUser(long userId)
 */
public class InterfaceAPIImpl implements InterfaceAPI {

    private RoomDAOImpl roomDAOImpl = RoomDAOImpl.getInstance();
    private HotelDAOImpl hotelDAOImpl = HotelDAOImpl.getInstance();
    private UserDAOImpl userDAOImpl = UserDAOImpl.getInstance();

    //receive hotel name, return collection of hotels with that name
    @Override
    public Collection<Hotel> findHotelByName(String name) {
        return hotelDAOImpl.getHotelByName(name);
    }

    //receive city name, return collection of hotels in the city
    @Override
    public Collection<Hotel> findHotelByCity(String city) {
        return hotelDAOImpl.getHotelByCity(city);
    }

    //searches room by id and hotel id, used by bookRoom, cancelReservation
    private Room findRoom(long roomId, long hotelId) throws NotFoundException {
        try {
            return roomDAOImpl.getRoomByRoomIdAndHotelId(roomId, hotelId);
        } catch (NoSuchElementException e) {
            throw new NotFoundException("room " + roomId + " wasn't found");
        }
    }

    //searches user by id, used by bookRoom, cancelReservation
    private User findUser(long userId) throws NotFoundException {
        try {
            return userDAOImpl.getUserById(userId);
        } catch (NoSuchElementException e) {
            throw new NotFoundException("user " + userId + " wasn't found");
        }
    }

    //searches for Room with given parameters and set isReserved in Room for true
    @Override
    public void bookRoom(long roomId, long userId, long hotelId) throws NotFoundException {

        //search room and user
        Room room = findRoom(roomId, hotelId);
        User user = findUser(userId);

        //break method if room is already reserved
        if (room.isReserved()) {
            System.out.println("Room " + room.getId() + " is already reserved.");
            return;
        }

        //add user to the room
        room.setUserReserved(user);

        //set isReserved flag for true
        room.setReserved(true);
        System.out.println(AuthorizedUser.getAuthorizedUser().getName() +
                " has reserved Room{id=" + room.getId() + " hotelId= " + room.getHotelId() + "}.");
    }

    //searches for Room with given parameters and set isReserved in Room for false
    @Override
    public void cancelReservation(long roomId, long userId, long hotelId) throws AuthorisationException, NotFoundException {
        //search room and user
        Room room = findRoom(roomId, hotelId);
        User user = findUser(userId);

        //clear User from Room
        if (user.equals(room.getUserReserved())) {
            room.setUserReserved(null);
        } else
            throw new AuthorisationException("Not authorised for this action");

        //set isReserved flag for false
        room.setReserved(false);
        System.out.println("reservation is canceled");
    }

    // searches for rooms with given parameters, throws NumberFormatException if value format isn't correct
    // key - parameter name, value - parameter value
    public Collection<Room> findRoom(Map<String, String> params) throws NumberFormatException {
        return roomDAOImpl.getRoomByParams(params);
    }

    //before start we need to register our user by MK
    public void registerUser(User user) {
        AuthorizedUser.setAuthorizedUser(user);
        userDAOImpl.save(user);
        System.out.println(user + " is registered...");
    }
}