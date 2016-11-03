package main.dao;

import main.model.Room;

import java.util.Collection;

public class RoomDAOImpl extends AbstractDAOImpl<Room> {

    private static RoomDAOImpl singletonInstance;

    private RoomDAOImpl(){}

    public static void initialize(Collection<Room> collection){
        if (singletonInstance == null) {
            singletonInstance = new RoomDAOImpl();
            singletonInstance.setCollection(collection);
        }
    }

    public static RoomDAOImpl getInstance(){
        return singletonInstance;
    }

    public static Collection<Room> getRooms() {
        return singletonInstance.getCollection();
    }
}
