package main.controller;




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
 * TODO check if works:-)
 *
 * TODO Java8
 * TODO Polymorphism
 * TODO exceptions
 * TODO separate search method
 */
public class InterfaceAPIImpl implements InterfaceAPI{

    //TODO delete when collections could be received from DB
    List<Hotel> hotels = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();


    //receive hotel name, return collection of hotels with that name
    @Override
    public Collection<Hotel> findHotelbyName(String name) {

        Collection<Hotel> searchResult = new ArrayList<>(); // replace for LinkedList?

        for (Hotel hotel: hotels) {
            if(hotel.getHotelName().equals(name))
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
        if (roomSearch.isReserved() == true){
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
        if (roomSearch.isReserved() == true){
            System.out.println("user wasn't found");
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

    //TODO Collection<Hotel> findRoom(Map<String, String> params)
    @Override
    public Collection<Hotel> findRoom(Map<String, String> params) {

        return null;
    }

    public InterfaceAPIImpl(List<Hotel> hotels, List<User> users, List<Room> rooms) {
        this.hotels = hotels;
        this.users = users;
        this.rooms = rooms;
    }
}