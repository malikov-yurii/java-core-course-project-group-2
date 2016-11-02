package main.view;

import main.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{

        System.out.print("Please authorize to continue (Enter your name): ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        User authorizedUser = new User(br.readLine());

        while (true){
            System.out.print(  "\nEnter \"1\" to find hotel by name.");
            System.out.print(  "\nEnter \"2\" to find hotel by city.");
            System.out.print(  "\nEnter \"3\" to book room.");
            System.out.print(  "\nEnter \"4\" to cancel reservation.");
            System.out.print(  "\nEnter \"5\" to find room by params.");
            System.out.print(  "\nEnter \"Q\" or \"q\" to quit.");
            System.out.print("\n\nEnter your choice : ");
            String choice = br.readLine();
            if ("Q".equals(choice) || "q".equals(choice)) {
                System.out.println("Application terminated.");
                break;
            }

            while (true) {
                switch (choice) {
                    case "1": /* find hotel by name */
                        break;
                    case "2": /* find hotel by city */
                        break;
                    case "3": /* book room. */
                        break;
                    case "4": /* cancel reservation. */
                        break;
                    case "5": /* find room by params. */
                        break;
                    default:
                        System.out.print("\n\nNot correct Choice. Please enter {1-5} choice : ");
                        choice = br.readLine();
                }
            }
        }
    }
}
