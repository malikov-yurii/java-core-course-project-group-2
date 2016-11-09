package main.view;

import main.dao.RoomDAOImpl;
import main.model.CurrentUser;
import main.model.Room;
import main.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladislav on 03.11.16.
 *
 * All methods that main use
 */
public class MainUtil {

    //MS: right not it just add 25 empty lines, little bit
    public final static void clrscr(){
        for(int clear = 0; clear < 50; clear++)
        {
            System.out.println() ;
        }
    }

    public final static long roomId(BufferedReader br) throws IOException {
        System.out.println();
        System.out.println("Enter room's id: ");
        String roomid = br.readLine();
        return Integer.valueOf(roomid);
    }

   /* public final static long UserId(BufferedReader br) throws IOException {
        System.out.println("Enter user's id: ");
        String userid = br.readLine();
        return Integer.valueOf(userid);
    }*/

    public final static long hotelId(BufferedReader br) throws IOException {
        System.out.println("Enter hotel's id: ");
        String hotid = br.readLine();
        return Integer.valueOf(hotid);
    }

    public final static Map<String, String> getParameters(BufferedReader br) throws IOException {
        Map<String, String> map = new HashMap<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("no")){
        System.out.println("Enter parameter's name for searching room (price, persons, id): ");
            String key = br.readLine();   // key - parameter name, value - parameter value
        if (key.equalsIgnoreCase("id"))
        {
            System.out.println("You want ID of hotel(use 'hotelId' string) or ID of room(use 'roomId' string)?");
            key=br.readLine();
        }
        System.out.println("Enter parameter's value for searching room: ");
        String value = br.readLine();
        map.put(key, value);
            System.out.println("Dou want enter more parameters?\nyes/no");
            choice = br.readLine();
        }
        return map;
    }

    // prints rooms from db, return false if there are no free rooms
    public final static boolean printFreeRooms() throws IOException {
        boolean anyReserved = false;

        System.out.println("Available rooms:");
        Collection<Room> rooms = RoomDAOImpl.getInstance().getList();
        for (Room room:rooms) {
            if(!room.isReserved()){
                anyReserved = true;
                System.out.println(room);
            }
        }
        if(!anyReserved){
            System.out.println("There are no free rooms");
        }
        return anyReserved;
    }

    //prints rooms reserved by CurrentUser, return false if there are no rooms reserved
    public final static boolean printUserRooms() throws IOException {
        boolean anyReserved = false;

        User currentUser = CurrentUser.getCurrentUser();
        Collection<Room> rooms = RoomDAOImpl.getInstance().getList();
        System.out.println("Rooms reserved by " + currentUser.getName() + ":");

        for (Room room:rooms) {
            if (currentUser.equals(room.getUserReserved())){
                anyReserved = true;
                System.out.println(room);
            }
        }

        if(!anyReserved){
            System.out.println("There are no rooms reserved by " + currentUser.getName());
        }
        return anyReserved;
    }

    public final static boolean checkUserReserv() throws IOException {
        boolean anyReserved = false;
        User currentUser = CurrentUser.getCurrentUser();
        Collection<Room> rooms = RoomDAOImpl.getInstance().getList();

        for (Room room:rooms) {
            if (currentUser.equals(room.getUserReserved()))
                anyReserved = true;
        }
        return anyReserved;
    }

}
