package main.view;

import main.controller.InterfaceAPIImpl;
import main.datasourse.TestData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void clrscr(){
        for(int clear = 0; clear < 25; clear++)
        {
            System.out.println() ;
        }
    }

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


        String choice1 = "";
        InterfaceAPIImpl interfaceAPI = new InterfaceAPIImpl();

        while (!choice1.equalsIgnoreCase("0")){
            System.out.println("\n---------Menu---------\n\n1. Find hotel by name\n2. Find hotel by city\n3. Book room\n4. Cancel reservation\n5. Find room by params.\n0. Quit.\n");
            choice1 = br.readLine();

            switch(choice1){
                case "1":
                {
                    clrscr();
                    System.out.println("Enter name of hotel: ");    //find hotel by name
                    String hotname = br.readLine();
                    System.out.println("Rezult of your request: "+interfaceAPI.findHotelbyName(hotname));
                    break;
                }
                case "2":
                {
                    clrscr();
                    System.out.println("\nEnter city of hotel: ");  //find hotel by city
                    String hotcity = br.readLine();
                    System.out.println("Rezult of your request: "+interfaceAPI.findHotelbyCity(hotcity));
                    break;
                }
                case "3":
                {
                    clrscr();
                    System.out.println("Enter room's id: ");        //book room
                    String roomid = br.readLine();
                    long a = Integer.valueOf(roomid);
                    System.out.println("Enter user's id: ");
                    String userid = br.readLine();
                    long b = Integer.valueOf(userid);
                    System.out.println("Enter hotel's id: ");
                    String hotid = br.readLine();
                    long c = Integer.valueOf(hotid);
                    interfaceAPI.bookRoom(a, b, c);
                    break;
                }
                case "4":
                {
                    clrscr();
                    System.out.println("Enter room's id: ");    //cancel reserv
                    String roomid = br.readLine();
                    long a1 = Integer.valueOf(roomid);
                    System.out.println("Enter user's id: ");
                    String userid = br.readLine();
                    long b1 = Integer.valueOf(userid);
                    System.out.println("Enter hotel's id: ");
                    String hotid = br.readLine();
                    long c1 = Integer.valueOf(hotid);
                    interfaceAPI.cancelReservation(a1, b1, c1);
                    break;
                }
                case "5":
                {
                    Map<String, String> map = new HashMap<>();      //find room by params

                    //interfaceAPI.findRoom();
                    break;
                }
                case "0":
                {
                    clrscr();
                    System.out.println("Good Bye!");            //exit
                    break;
                }
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
