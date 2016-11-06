package main.controller;


import main.dao.HotelDAOImpl;
import main.dao.RoomDAOImpl;
import main.dao.UserDAOImpl;
import main.model.CurrentUser;
import main.model.Hotel;
import main.model.Room;
import main.model.User;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Created by Mykhailo Senchuk on 11/2/2016.
 *
 *
 * takes data from DAO(empty constructor)
 *
 * implements methods:
 *
 * public Collection<Hotel>  findHotelbyName(String name)
 * public Collection<Hotel> findHotelbyCity(String city)
 * public void bookRoom(long roomId, long userId, long hotelId)
 * public void cancelReservation(long roomId, long userId, long hotelId)
 * public Collection<room> findRoom(Map<String, String> params)
 *
 *  supporting methods:
 *  public Room searchRoom(long roomId, long hotelId)
 *  public User searchUser(long userId)
 *  public boolean validateRoom(Room room, User user)
 *
 *
 *
 *
 *
 *
 */
public class InterfaceAPIImpl implements InterfaceAPI {

    private RoomDAOImpl roomDAOImpl = RoomDAOImpl.getInstance();
    private HotelDAOImpl hotelDAOImpl = HotelDAOImpl.getInstance();


    //receive hotel name, return collection of hotels with that name
    @Override
    public Collection<Hotel> findHotelbyName(String name) {

        return hotelDAOImpl.getHotelByName(name);

    }

    //receive city name, return collection of hotels in the city
    @Override
    public Collection<Hotel> findHotelbyCity(String city) {

        return hotelDAOImpl.getHotelByCity(city);
    }

    public Room searchRoom(long roomId, long hotelId) {
        try {
            return RoomDAOImpl.getRooms()
                    .stream()
                    .filter(room -> room.getId() == roomId && room.getHotelId() == hotelId)
                    .findFirst()
                    .get();
        }
        catch (NoSuchElementException e){
            System.out.println("room wasn't found");
            return null;
        }
    }
    public User searchUser(long userId) {
        try {
            return UserDAOImpl.getUsers()
                    .stream()
                    .filter(user -> user.getId() == userId)
                    .findFirst()
                    .get();
        }
        catch (NoSuchElementException e){
            System.out.println("user wasn't found");
            return null;
        }
    }

    public boolean validateRoom(Room room, User user){
        //break method if room is reserved
        if (room == null) {
            return false;
        }

        //break method if user wasn't found
        if (user == null) {
            return false;
        }
        return true;
    }

    //searches for Room with given parameters and set isReserved in Room for true
    @Override
    public void bookRoom(long roomId, long userId, long hotelId) {

        //search room and user
        Room room = null;
        room = searchRoom(roomId,hotelId);
        User user = null;
        user = searchUser(userId);

        //break method if room or user wasn't found
        if(!validateRoom(room,user)) return;

        //break method if room is already reserved
        if (room.isReserved()) {
            System.out.println("room is already reserved");
            return;
        }

        //add user to the room
        room.setUserReserved(user);

        //set isReserved flag for true
        room.setReserved(true);
        System.out.println("room is reserved");
    }
    //searches for Room with given parameters and set isReserved in Room for false
    @Override
    public void cancelReservation(long roomId, long userId, long hotelId) {
        //search room and user
        Room room = null;
        room = searchRoom(roomId,hotelId);
        User user = null;
        user = searchUser(userId);

        //break method if room isn't valid
        if (!validateRoom(room,user)) {
            return;
        }

        //clear User from Room
        room.setUserReserved(null);

        //set isReserved flag for false
        room.setReserved(false);
        System.out.println("reservation is canceled");
    }

    // one of possible realization
    public Collection<Room> findRoom(Map<String, String> params) {
        Predicate<Room> testByParams = new Predicate<Room>() {
            @Override
            public boolean test(Room room) {
                if (params.containsKey("price") &&
                        Double.parseDouble(params.get("price")) != room.getPrice()) {
                    return false;
                }
                if (params.containsKey("persons") &&
                        Integer.parseInt(params.get("persons")) != room.getPersons()) {
                    return false;
                }
                if (params.containsKey("hotelId") &&
                        Long.parseLong(params.get("hotelId")) != room.getHotelId()) {
                    return false;
                }
                if (params.containsKey("roomId") &&
                        Long.parseLong(params.get("roomId")) != room.getId()) {
                    return false;
                }
                return true;
            }
        };
        return roomDAOImpl.getRooms()
                .stream()
                .filter(testByParams)
                .collect(Collectors.toSet());
    }


    //before start we need to register our user by MK
    public void registerUser(User user) {
        CurrentUser currentUser = new CurrentUser();
        currentUser.setCurrentUser(user);
        System.out.println(user + " is registered...");

        UserDAOImpl.getInstance().save(user);
    }

}
