package main.model;

import java.util.Collection;

public class RoomDAOImpl extends AbstractDAOImpl<Room> {

    private static Collection<Room> rooms;

    private static RoomDAOImpl singletonInstance;

    private RoomDAOImpl(){

    }

    public static void initialize(Collection<Room> collection){
        if (singletonInstance == null) {
            singletonInstance = new RoomDAOImpl();
            rooms = collection;
        }
    }

    public static RoomDAOImpl getInstance(){
        return singletonInstance;
    }

    public Collection<Room> getCollection() {
        return rooms;
    }
}
