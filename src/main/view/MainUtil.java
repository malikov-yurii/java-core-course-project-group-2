package main.view;

import main.dao.RoomDAOImpl;
import main.model.AuthorizedUser;
import main.model.Room;
import main.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladislav on 03.11.16.
 */
class MainUtil {

    private static final User authorizedUser = AuthorizedUser.getAuthorizedUser();
    private static RoomDAOImpl roomDAOImpl = RoomDAOImpl.getInstance();

    static long getRoomIdFromConsole(BufferedReader br) throws IOException {
        System.out.println("\nEnter room's id: ");
        return Integer.valueOf(br.readLine());
    }

    static long getHotelIdFromConsole(BufferedReader br) throws IOException {
        System.out.println("Enter hotel's id: ");
        return Integer.valueOf(br.readLine());
    }

    static Map<String, String> getParameters(BufferedReader br) throws IOException {
        Map<String, String> map = new HashMap<>();
        System.out.println("Enter of parameters for rooms search started.");
        String key = "";
        while (true) {
            System.out.println("Please enter next parameter's name for searching  room (price, persons, roomId, hotelId)." +
                    " Or type 'exit' to end parameter input.");
            key = br.readLine();   // key - parameter name, value - parameter value
            if (key.equalsIgnoreCase("exit")) {
                System.out.println("Enter of parameters terminated.");
                return map;
            }

            if (!key.equalsIgnoreCase("hotelId")
                    && !key.equalsIgnoreCase("roomId")
                    && !key.equalsIgnoreCase("persons")
                    && !key.equalsIgnoreCase("price")) {
                System.out.println("Last input parameter isn't correct. Please start input from the outset.");
                continue;
            }

            System.out.println("Enter parameter's value for searching room: ");
            String value = br.readLine();
            map.put(key, value);
        }
    }

    // prints rooms from datasourse, return false if there are no free rooms
    static boolean printFreeRooms() {
        if (roomDAOImpl.getList().stream().allMatch(Room::isReserved)) {
            System.out.println("There are no free rooms");
            return false;
        }

        System.out.println("Available rooms:");
        roomDAOImpl.getList()
                .stream()
                .filter(room -> !room.isReserved())
                .forEach(System.out::println);
        return true;
    }

    //prints rooms reserved by authorizedUser, return false if there are no rooms reserved
    static boolean printUserRooms() {

        if (!roomDAOImpl.getList().stream().anyMatch(room -> authorizedUser.equals(room.getUserReserved()))) {
            System.out.println("There are no rooms reserved by " + authorizedUser.getName());
            return false;
        }

        System.out.println("Rooms reserved by " + authorizedUser.getName() + ":");
        roomDAOImpl.getList()
                .stream()
                .filter(room -> authorizedUser.equals(room.getUserReserved()))
                .forEach(System.out::println);
        return true;
    }
}
