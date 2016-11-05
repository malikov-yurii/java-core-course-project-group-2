package main.controller;


import main.dao.HotelDAOImpl;
import main.dao.RoomDAOImpl;
import main.dao.UserDAOImpl;
import main.model.CurrentUser;
import main.model.Hotel;
import main.model.Room;
import main.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Mykhailo Senchuk on 11/2/2016.
 * <p>
 * require collection of <Hotel>
 * require collection of <User>
 * require collection of <Room>
 * takes from DAO(empty constructor) or as parameters
 * <p>
 * working(additional testing is appreciated):
 * public Collection<Hotel> findHotelbyCity(String city)
 * public Collection<Hotel> findHotelbyCity(String city)
 * public void bookRoom(long roomId, long userId, long hotelId)
 * public void cancelReservation(long roomId, long userId, long hotelId)
 * <p>
 * TODO Collection<Hotel> findRoom(Map<String, String> params)
 * <p>
 * TODO Java8
 * TODO Polymorphism
 * TODO exceptions
 * TODO separate search method
 */
public class InterfaceAPIImpl implements InterfaceAPI {

    private RoomDAOImpl roomDAOImpl = RoomDAOImpl.getInstance();

    private Collection<Hotel> hotels;
    private Collection<User> users;
    private Collection<Room> rooms;


    //get data from database
    //TODO try catch for empty DB
    public InterfaceAPIImpl() {
        try {
            hotels = HotelDAOImpl.getHotels();
            users = UserDAOImpl.getUsers();
            rooms = RoomDAOImpl.getRooms();
        } catch (NullPointerException e) {
            //Пока что просто обработали и отправили письмо
            //System.out.println("There is NullPointerException");
        }

    }

    //get data from input parameters
    public InterfaceAPIImpl(List<Hotel> hotels, List<User> users, List<Room> rooms) {
        this.hotels = hotels;
        this.users = users;
        this.rooms = rooms;
    }

    //receive hotel name, return collection of hotels with that name
    @Override
    public Collection<Hotel> findHotelbyName(String name) {

        Collection<Hotel> searchResult = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name))
                searchResult.add(hotel);
        }
        return searchResult;
    }

    //receive city name, return collection of hotels in the city
    @Override
    public Collection<Hotel> findHotelbyCity(String city) {

        Collection<Hotel> searchResult = new ArrayList<>();

        for (Hotel hotel : hotels) {
            if (hotel.getCity().equals(city))
                searchResult.add(hotel);
        }
        return searchResult;
    }

    //searches for Room with given parameters and set isReserved in Room for true
    @Override
    public void bookRoom(long roomId, long userId, long hotelId) {

        //search room
        Room roomSearch = null;
        for (Room room : rooms) {
            if (room.getId() == roomId && room.getHotelId() == hotelId) {
                roomSearch = room;
                break;
            }
        }

        //break method if room wasn't found
        if (roomSearch == null) {
            System.out.println("room wasn't found");
            return;
        }

        //break method if room is already reserved
        if (roomSearch.isReserved()) {
            System.out.println("room is already reserved");
            return;
        }

        //search user
        User userSearch = null;
        for (User user : users) {
            if (user.getId() == userId) {
                userSearch = user;
                break;
            }
        }

        //break method if user wasn't found
        if (userSearch == null) {
            System.out.println("user wasn't found");
            return;
        }

        //break method if room is already reserved
        if (roomSearch.isReserved()) {
            System.out.println("room is already reserved");
            return;
        }

        //add user
        roomSearch.setUserReserved(userSearch);

        //set isReserved flag for true
        roomSearch.setReserved(true);
        System.out.println("room is reserved");

    }

//    one of possible realization
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

// not correct   
    // receive Map with key - parameter name, value - parameter value
    //
    // need to receive all parameters: price, persons, hotelId
    /*@Override
    public Collection<Room> findRoom(Map<String, String> params) {
        Collection<Room> result = new HashSet<>();

        //check on price

            if (params.containsKey("price")) {
                result = roomDAOImpl.getRoomByPrice(Double.parseDouble(params.get("price")));
            }

        //check on persons
        if (params.containsKey("persons")) {
            result.addAll(roomDAOImpl.getRoomByPersons(valueOf(params.get("persons"))));
        }

        //check on hotelid
        if (params.containsKey("hotel") || params.containsKey("hotelId")) {
            result.addAll(roomDAOImpl.getRoomByHotelId(Long.parseLong(params.get("hotel"))));
        }

        //check on roomid
        if (params.containsKey("room") || params.containsKey("roomId")) {
                result.addAll(roomDAOImpl.getRoomByRoomId(Long.parseLong(params.get("room"))));
        }
        //else  System.out.println("Wrong parameter");

        return result;
    }*/

    //searches for Room with given parameters and set isReserved in Room for false
    @Override
    public void cancelReservation(long roomId, long userId, long hotelId) {

        //search room
        Room roomSearch = null;
        for (Room room : rooms) {
            if (room.getId() == roomId && room.getHotelId() == hotelId) {
                roomSearch = room;
                break;
            }
        }

        //break method if room wasn't found
        if (roomSearch == null) {
            System.out.println("room wasn't found");
            return;
        }

        //break method if room isn't reserved
        if (!roomSearch.isReserved()) {
            return;
        }

        //break method if userReserved has different ID
        if (roomSearch.getUserReserved().getId() != userId) {
            System.out.println("not correct user");
            return;
        }

        //clear User from Room
        roomSearch.setUserReserved(null);

        //set isReserved flag for false
        roomSearch.setReserved(false);
        System.out.println("reservation is canceled");
    }

    //before start we need to register our user by MK
    public void registerUser(User user) {
        CurrentUser currentUser = new CurrentUser();
        currentUser.setCurrentUser(user);
        System.out.println(user + " is registered...");

        UserDAOImpl.getInstance().save(user);
    }

}
