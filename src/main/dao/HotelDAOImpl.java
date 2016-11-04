package main.dao;

import main.model.Hotel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Hotel> getHotelByName(String name){
        return getCollection()
                .stream()
                .filter(h -> name.equals(h.getName()))
                .collect(Collectors.toList());
    }

    public List<Hotel> getHotelByCity(String city){
        return getCollection()
                .stream()
                .filter(h -> city.equals(h.getCity()))
                .collect(Collectors.toList());
    }

    public List<Hotel> getHotelByNameAndCity(String name, String city){
        return getCollection()
                .stream()
                .filter(h -> name.equals(h.getName()) && city.equals(h.getCity()))
                .collect(Collectors.toList());
    }
}
