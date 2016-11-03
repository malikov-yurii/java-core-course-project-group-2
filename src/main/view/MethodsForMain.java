package main.view;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Vladislav on 03.11.16.
 *
 * All methods that main use
 */
public class MethodsForMain {

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

}
