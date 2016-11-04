package main.view;

import main.dao.RoomDAOImpl;
import main.model.CurrentUser;
import main.model.Room;
import main.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Vladislav on 03.11.16.
 *
 * All methods that main use
 */
public class MethodsForMain {

    //MS: right not it just add 25 empty lines, little bit
    public final static void clrscr(){
        for(int clear = 0; clear < 25; clear++)
        {
            System.out.println() ;
        }
    }

    public final static long RoomId(BufferedReader br) throws IOException {
        System.out.println("Enter room's id: ");
        String roomid = br.readLine();
        return Integer.valueOf(roomid);
    }

    public final static long UserId(BufferedReader br) throws IOException {
        System.out.println("Enter user's id: ");
        String userid = br.readLine();
        return Integer.valueOf(userid);
    }

    public final static long HotelId(BufferedReader br) throws IOException {
        System.out.println("Enter hotel's id: ");
        String hotid = br.readLine();
        return Integer.valueOf(hotid);
    }

    // prints rooms from db, return false is there are no free rooms
    public final static boolean PrintFreeRooms() throws IOException {
        boolean anyReserved = false;

        System.out.println("Available rooms:");
        Collection<Room> rooms = RoomDAOImpl.getRooms();
        for (Room room:rooms) {
            if(!room.isReserved()){
                anyReserved = true;
                System.out.println(room);
            }
        }
        if(!anyReserved){
            System.out.println("there are no free rooms");
        }
        return anyReserved;
    }

    //prints rooms reserved by CurrentUser, return false is there are no rooms reserved
    public final static boolean PrintUserRooms() throws IOException {
        boolean anyReserved = false;

        User currentUser = CurrentUser.getCurrentUser();
        Collection<Room> rooms = RoomDAOImpl.getRooms();
        System.out.println("Rooms reserved by " + currentUser.getName() + ":");

        for (Room room:rooms) {
            if (currentUser.equals(room.getUserReserved())){
                anyReserved = true;
                System.out.println(room);
            }
        }

        if(!anyReserved){
            System.out.println("there are no rooms reserved by " + currentUser.getName());
        }
        return anyReserved;
    }


}
