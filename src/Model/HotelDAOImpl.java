package Model;

import java.util.*;

public class HotelDAOImpl implements AbstractDAO<Hotel> {

    private final Collection<Hotel> hotels = new HashSet<>(Arrays.asList(
            HOTEL_DRUGHBA_KIEV, HOTEL_UKRAINA_KIEV, HOTEL_OPTIMA_CHERKASSY,
            HOTEL_APELSIN_CHERKASSY, HOTEL_DNESTR_LVIV, HOTEL_GETMAN_LVIV
    ));

    public final static Hotel HOTEL_DRUGHBA_KIEV      = new Hotel("Drughba", "Kiev");
    public final static Hotel HOTEL_UKRAINA_KIEV      = new Hotel("Ukraina", "Kiev");
    public final static Hotel HOTEL_OPTIMA_CHERKASSY  = new Hotel("Optima", "Cherkassy");
    public final static Hotel HOTEL_APELSIN_CHERKASSY = new Hotel("Apelsin", "Cherkassy");
    public final static Hotel HOTEL_DNESTR_LVIV       = new Hotel("Dnestr", "Lviv");
    public final static Hotel HOTEL_GETMAN_LVIV       = new Hotel("Getman", "Lviv");

    public Hotel getByNameAndCity(String name, String city){
        return hotels
                .stream()
                .filter(hotel -> name.equals(hotel.getHotelName()) && city.equals(hotel.getCity()))
                .findFirst()
                .get();
    }

    @Override
    public Hotel save(Hotel object) {
        return null;
    }

    @Override
    public void delete(Hotel object) {

    }

    @Override
    public void deleteAll(List<Hotel> list) {

    }

    @Override
    public void saveAll(List<Hotel> list) {

    }

    @Override
    public List<Hotel> getList() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Hotel get(long id) {
        return null;
    }
}
