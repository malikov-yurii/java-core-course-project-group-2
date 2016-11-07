package main.view;

import main.controller.InterfaceAPIImpl;
import main.dao.RoomDAOImpl;
import main.datasourse.TestData;
import main.model.CurrentUser;
import main.model.Room;
import main.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException {

        TestData.initializeDAOWithTestData();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
//      Я пока оставлю это здесь, пусть будет как один из вариантов, так как я его еще днем накидал
//      Но я не смотрел последний вебинар, поэтому правильная реализация авторизации за Михаилом Косицким.
        while (true) {
            System.out.print("Please authorize to continue. \nEnter your login : ");
            String login = br.readLine();
            System.out.print("\nEnter your password : ");
            String password = br.readLine();
            User authorizedUser = new User(login, password);
            if (UserDAOImpl.getInstance().getUsers().contains(authorizedUser)) {
                System.out.println("Access allowed.");
                break;
            }
            System.out.println("Access denied.");
        }
*/
        //-----------------Start Authorization--------------------------------
        InterfaceAPIImpl interfaceAPI = new InterfaceAPIImpl();
        System.out.print("Enter username without space: ");
        Scanner scanner = new Scanner(System.in);
        String readUser = scanner.next();
        System.out.print("Enter password: ");
        String readPassword = scanner.next();
        interfaceAPI.registerUser(new User(readUser, readPassword));
        //scanner.close(); /*Вызывает закрытие потока ввода данных. Подходит для теста, но не для прода*/
        System.out.println("The current User is: "+ CurrentUser.getCurrentUser());
        //-----------------------Finish Authorization------------------------

        String choice1 = "";

        while (!choice1.equalsIgnoreCase("0")){
            System.out.println("\n---------Menu---------\n\n1. Find hotel by name\n2. Find hotel by city\n3. Book room\n4. Cancel reservation\n5. Find room by parameters\n6. Show user's reservation\n0. Quit\n");
            choice1 = br.readLine();

            switch(choice1){
                case "1":
                {

                    // MethodsForMain.clrscr();
                    System.out.println("Enter name of hotel: ");    //find hotel by name
                    String hotname = br.readLine();
                    System.out.println("Rezult of your request: "+interfaceAPI.findHotelbyName(hotname));
                    break;
                }
                case "2":
                {
                    //MethodsForMain.clrscr();
                    System.out.println("\nEnter city of hotel: ");  //find hotel by city
                    String hotcity = br.readLine();
                    System.out.println("Rezult of your request: "+interfaceAPI.findHotelbyCity(hotcity));
                    break;
                }
                case "3":
                {
                   // MethodsForMain.clrscr();                    //book room
                    User currentUser = CurrentUser.getCurrentUser();
                    MethodsForMain.PrintFreeRooms();  //print available rooms
                    interfaceAPI.bookRoom(MethodsForMain.RoomId(br), currentUser.getId(), MethodsForMain.HotelId(br));
                    break;


                }
                case "4":
                {
                    //MethodsForMain.clrscr();                //cancel reserv
                    MethodsForMain.PrintUserRooms(); //print rooms of current user
                    if (MethodsForMain.CheckUserReserv())
                    {
                    User currentUser = CurrentUser.getCurrentUser();
                    interfaceAPI.cancelReservation(MethodsForMain.RoomId(br), currentUser.getId(), MethodsForMain.HotelId(br));}
                    else System.out.println("You don't have any reservation.");
                    break;
                }
                case "5":
                {
                   // MethodsForMain.clrscr();
                    try {
                        Collection<Room> roomsFoundByParams = interfaceAPI.findRoom(MethodsForMain.Parameters(br));
                        System.out.println((roomsFoundByParams.size() != 0) ? roomsFoundByParams : "We don't find any matches for these parameters");
                    }catch(NumberFormatException e){
                        System.out.println("Parser error! Wrong format! Need number!");
                    }
                        break;
                }
                case "0":
                {
                    //MethodsForMain.clrscr();
                    System.out.println("Good Bye!");            //exit
                    break;
                }
                case "6":
                {
                    // MethodsForMain.clrscr();
                    MethodsForMain.PrintUserRooms(); //print rooms of current user
                    break;
                }
                default:
                    System.out.print("\nPlease, choose 1-5 or 0 : ");
            }
        }

        br.close();
        /*while (true) {
            System.out.print("\nEnter \"1\" to find hotel by name.");
            System.out.print("\nEnter \"2\" to find hotel by city.");
            System.out.print("\nEnter \"3\" to book room.");
            System.out.print("\nEnter \"4\" to cancel reservation.");
            System.out.print("\nEnter \"5\" to find room by params.");
            System.out.print("\nEnter \"Q\" or \"q\" to quit.");
            System.out.print("\n\nEnter your choice : ");
            String choice = br.readLine();
            if ("Q".equals(choice) || "q".equals(choice)) {
                System.out.println("Application terminated.");
                break;
            }

            while (true) {
                switch (choice) {
                    case "1": /* find hotel by name *//*
                        break;
                    case "2": /* find hotel by city *//*
                        break;
                    case "3": /* book room. *//*
                        break;
                    case "4": /* cancel reservation. *//*
                        break;
                    case "5": /* find room by params. *//*
                        break;
                    default:
                        System.out.print("\n\nNot correct Choice. Please enter {1-5} choice : ");
                        choice = br.readLine();
                }
            }
        }*/
    }
}
