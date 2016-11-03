package main.view;

import main.controller.InterfaceAPI;
import main.controller.InterfaceAPIImpl;
import main.dao.UserDAOImpl;
import main.datasourse.TestData;
import main.model.Hotel;
import main.model.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mykhailo on 11/3/2016.
 * To test controller before Main class is created
 */
public class TestController {
    public static void main(String[] args) {
        TestData.initializeDAOWithTestData();

        User user = new User("pasha","12134");
        System.out.println(user.getId());

        Collection<User> users = new ArrayList<>();
        users.add(user);
        UserDAOImpl.initialize(users);




        InterfaceAPI test = new InterfaceAPIImpl();
        test.bookRoom(1006,1067,1001);
        test.cancelReservation(1006,1067,1001);
        Collection<Hotel> hotels = test.findHotelbyCity("Kiev");
        hotels.forEach(System.out::println);

        hotels = test.findHotelbyName("Drughba");
        hotels.forEach(System.out::println);

    }
}
