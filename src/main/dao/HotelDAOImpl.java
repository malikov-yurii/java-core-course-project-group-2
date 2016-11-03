package main.dao;

import main.model.Hotel;

import java.util.Collection;

public class HotelDAOImpl extends AbstractDAOImpl<Hotel> {

    private static Collection<Hotel> hotels;

    private static HotelDAOImpl singletonInstance;

    private HotelDAOImpl(){

    }

    public static void initialize(Collection<Hotel> collection){
        if (singletonInstance == null) {
            singletonInstance = new HotelDAOImpl();
            hotels = collection;
        }
    }

    public static HotelDAOImpl getInstance(){
        return singletonInstance;
    }

    public Collection<Hotel> getHotels() {
        return hotels;
    }

    public Hotel getByNameAndCity(String name, String city){
        return hotels
                .stream()
                .filter(hotel -> name.equals(hotel.getName()) && city.equals(hotel.getCity()))
                .findFirst()
                .get();
    }
}
