package main.dao;

import main.model.Hotel;

import java.util.Collection;

public class HotelDAOImpl extends AbstractDAOImpl<Hotel> {

    private static HotelDAOImpl singletonInstance;

    private HotelDAOImpl(){}

    public static void initialize(Collection<Hotel> collection){
        if (singletonInstance == null) {
            singletonInstance = new HotelDAOImpl();
            singletonInstance.setCollection(collection);
        }
    }

    public static HotelDAOImpl getInstance(){
        return singletonInstance;
    }

    public static Collection<Hotel> getHotels() {
        return singletonInstance.getCollection();
    }

    public Hotel getByNameAndCity(String name, String city){
        return singletonInstance.getCollection()
                .stream()
                .filter(hotel -> name.equals(hotel.getName()) && city.equals(hotel.getCity()))
                .findFirst()
                .get();
    }
}
