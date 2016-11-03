package main.controller;




import main.dao.HotelDAOImpl;
import main.dao.RoomDAOImpl;
import main.dao.UserDAOImpl;
import main.model.Hotel;
import main.model.Room;
import main.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Mykhailo Senchuk on 11/2/2016.
 *
 * require collection of <Hotel>
 * require collection of <User>
 * require collection of <Room>
 *
 * working(additional testing is appreciated):
 * public Collection<Hotel> findHotelbyCity(String city)
 * public Collection<Hotel> findHotelbyCity(String city)
 * public void bookRoom(long roomId, long userId, long hotelId)
 * public void cancelReservation(long roomId, long userId, long hotelId)
 *
 * TODO Collection<Hotel> findRoom(Map<String, String> params)
 *
 * TODO Java8
 * TODO Polymorphism
 * TODO exceptions
 * TODO separate search method
 */
public class InterfaceAPIImpl implements InterfaceAPI{

    private Collection<Hotel> hotels;
    private Collection<User> users;
    private Collection<Room> rooms;


    //receive hotel name, return collection of hotels with that name
    @Override
    public Collection<Hotel> findHotelbyName(String name) {

        Collection<Hotel> searchResult = new ArrayList<>();

        for (Hotel hotel: hotels) {
            if(hotel.getName().equals(name))
                searchResult.add(hotel);
        }
        return searchResult;
    }

    //receive city name, return collection of hotels in the city
    @Override
    public Collection<Hotel> findHotelbyCity(String city) {

        Collection<Hotel> searchResult = new ArrayList<>();

        for (Hotel hotel: hotels) {
            if(hotel.getCity().equals(city))
                searchResult.add(hotel);
        }
        return searchResult;
    }

    //searches for Room with given parameters and set isReserved in Room for true
    @Override
    public void bookRoom(long roomId, long userId, long hotelId) {

        //search room
        Room roomSearch = null;
        for (Room room: rooms) {
            if(room.getId( ) == roomId && room.getHotelId() == hotelId) {
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
        if (roomSearch.isReserved()){
            System.out.println("room is already reserved");
            return;
        }

        //search user
        User userSearch = null;
        for (User user: users) {
            if(user.getId( ) == userId) {
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
        if (roomSearch.isReserved()){
            System.out.println("room is already reserved");
            return;
        }

        //add user
        roomSearch.setUserReserved(userSearch);

        //set isReserved flag for true
        roomSearch.setReserved(true);

    }

    //searches for Room with given parameters and set isReserved in Room for false
    @Override
    public void cancelReservation(long roomId, long userId, long hotelId) {

        //search room
        Room roomSearch = null;
        for (Room room: rooms) {
            if(room.getId( ) == roomId && room.getHotelId() == hotelId) {
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
        if (!roomSearch.isReserved()){
            return;
        }

        //break method if userReserved has different ID
        if (roomSearch.getUserReserved().getId() != userId){
            System.out.println("not correct user");
            return;
        }

        //clear User from Room
        roomSearch.setUserReserved(null);

        //set isReserved flag for false
        roomSearch.setReserved(false);
    }

    //TODO
    @Override
    public Collection<Hotel> findRoom(Map<String, String> params) {

        return null;
    }

    public InterfaceAPIImpl() {
        hotels = HotelDAOImpl.getInstance().getHotels();
        users = UserDAOImpl.getInstance().getUsers();
        rooms = RoomDAOImpl.getInstance().getCollection();
    }

    public InterfaceAPIImpl(List<Hotel> hotels, List<User> users, List<Room> rooms) {
        this.hotels = hotels;
        this.users = users;
        this.rooms = rooms;
    }
}
