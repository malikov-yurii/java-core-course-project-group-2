package main.dao;

import main.model.Hotel;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class HotelDAOImpl extends AbstractDAOImpl<Hotel> {

    private static HotelDAOImpl singletonInstance;

    private HotelDAOImpl(){
    }

    public static void initialize(Collection<Hotel> collection){
        if (singletonInstance == null) {
            singletonInstance = new HotelDAOImpl();
            singletonInstance.saveAll(collection);
        }
    }

    public static HotelDAOImpl getInstance(){
        return singletonInstance;
    }

    public Set<Hotel> getHotelByName(String name){
        return getList()
                .stream()
                .filter(h -> name.equals(h.getName()))
                .collect(Collectors.toSet());
    }

    public Set<Hotel> getHotelByCity(String city){
        return getList()
                .stream()
                .filter(h -> city.equals(h.getCity()))
                .collect(Collectors.toSet());
    }

    public Set<Hotel> getHotelByNameAndCity(String name, String city){
        return getList()
                .stream()
                .filter(h -> name.equals(h.getName()) && city.equals(h.getCity()))
                .collect(Collectors.toSet());
    }
}
