package Model;

import Model.HotelDAOImpl;
import Model.RoomDAOImpl;
import Model.UserDAOImpl;

public class DataSourcee {
    private static final UserDAOImpl userDAO = new UserDAOImpl();
    private static final RoomDAOImpl roomsDAO = new RoomDAOImpl();
    private static final HotelDAOImpl hotelDAO = new HotelDAOImpl();

    public static UserDAOImpl getUserDAO() {
        return userDAO;
    }

    public static RoomDAOImpl getRoomsDAO() {
        return roomsDAO;
    }

    public static HotelDAOImpl getHotelDAO() {
        return hotelDAO;
    }
}
