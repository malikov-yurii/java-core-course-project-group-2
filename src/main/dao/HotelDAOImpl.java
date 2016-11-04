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
}
