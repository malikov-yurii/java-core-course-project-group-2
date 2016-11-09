package main.view;

import main.controller.InterfaceAPI;
import main.controller.InterfaceAPIImpl;
import main.datasourse.TestData;
import main.model.AuthorizedUser;
import main.model.Room;
import main.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        TestData.initializeDAOWithTestData();

        //-----------------Start Authorization--------------------------------
        InterfaceAPIImpl interfaceAPI = new InterfaceAPIImpl();
        System.out.print("Enter username without space: ");
        Scanner scanner = new Scanner(System.in);
        String readUser = scanner.next();
        System.out.print("Enter password: ");
        String readPassword = scanner.next();
        interfaceAPI.registerUser(new User(readUser, readPassword));
        User authorizedUser = AuthorizedUser.getAuthorizedUser();
        System.out.println("The current User is: " + authorizedUser);
        //-----------------------Finish Authorization------------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice1 = "";
        while (!choice1.equalsIgnoreCase("0")) {
            System.out.println(
                    "\n---------Menu---------\n\n" +
                            "1. Find hotel by name\n" +
                            "2. Find hotel by city\n" +
                            "3. Book room\n" +
                            "4. Cancel reservation\n" +
                            "5. Find room by parameters\n" +
                            "6. Show user's reservation\n" +
                            "0. Quit\n");
            choice1 = br.readLine();

            switch (choice1) {
                case "1": //find hotel by name
                {
                    System.out.println("Enter name of hotel: ");
                    System.out.println("Result of your request: " + interfaceAPI.findHotelByName(br.readLine()));
                    break;
                }
                case "2": //find hotel by city
                {
                    System.out.println("\nEnter city of hotel: ");
                    System.out.println("Result of your request: " + interfaceAPI.findHotelByCity(br.readLine()));
                    break;
                }
                case "3": //book room
                {
                    //print available rooms
                    MainUtil.printFreeRooms();
                    try {
                        interfaceAPI.bookRoom(MainUtil.getRoomIdFromConsole(br), authorizedUser.getId(), MainUtil.getHotelIdFromConsole(br));
                    } catch (InterfaceAPI.NotFoundException e) {
                        System.out.println(e);
                    }
                    break;
                }
                case "4": //cancel reservation
                {
                    if (MainUtil.printUserRooms()) {  //print rooms of current user
                        try {
                            interfaceAPI.cancelReservation(MainUtil.getRoomIdFromConsole(br), authorizedUser.getId(), MainUtil.getHotelIdFromConsole(br));
                        } catch (InterfaceAPI.NotFoundException | InterfaceAPI.AuthorisationException e) {
                            System.out.println(e);
                        }
                    }
                    break;
                }
                case "5": //find rooms by params
                {
                    try {
                        Set<Room> roomsFoundByParams = interfaceAPI.findRoom(MainUtil.getParameters(br))
                                .stream()
                                .filter(room -> !room.isReserved())
                                .collect(Collectors.toSet());
                        if(roomsFoundByParams.size() != 0)
                            roomsFoundByParams.forEach(System.out::println);
                        else
                            System.out.println("There are no matches for given parameters");
                    } catch (NumberFormatException e) {
                        System.out.println("Parser error! Wrong format! Need number!");
                    }
                    break;
                }
                case "6": //print rooms of current user
                {
                    MainUtil.printUserRooms();
                    break;
                }
                case "0": //exit
                {
                    System.out.println("Good Bye!");
                    br.close();
                    break;
                }
                default:
                    System.out.print("\nPlease, choose 1-5 or 0 : ");
            }
        }
    }
}
