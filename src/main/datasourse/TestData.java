package main.datasourse;

import main.dao.HotelDAOImpl;
import main.dao.RoomDAOImpl;
import main.dao.UserDAOImpl;
import main.model.*;

import java.util.Arrays;
import java.util.HashSet;

public class TestData {
    public final static Hotel HOTEL_DRUGHBA_KIEV      = new Hotel("Drughba", "Kiev");
    public final static Hotel HOTEL_UKRAINA_KIEV      = new Hotel("Ukraina", "Kiev");
    public final static Hotel HOTEL_OPTIMA_CHERKASSY  = new Hotel("Optima", "Cherkassy");
    public final static Hotel HOTEL_APELSIN_CHERKASSY = new Hotel("Apelsin", "Cherkassy");
    public final static Hotel HOTEL_DNESTR_LVIV       = new Hotel("Dnestr", "Lviv");
    public final static Hotel HOTEL_GETMAN_LVIV       = new Hotel("Getman", "Lviv");

    public static final Room ROOM0_UKRAINA = new Room(200.50, 2, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM1_UKRAINA = new Room(220.50, 1, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM2_UKRAINA = new Room(230.50, 3, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM3_UKRAINA = new Room(240.50, 4, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM4_UKRAINA = new Room(250.50, 1, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM5_UKRAINA = new Room(260.50, 2, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM6_UKRAINA = new Room(270.50, 3, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM7_UKRAINA = new Room(280.50, 4, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM8_UKRAINA = new Room(290.50, 2, null, false, HOTEL_UKRAINA_KIEV.getId());
    public static final Room ROOM9_UKRAINA = new Room(300.50, 1, null, false, HOTEL_UKRAINA_KIEV.getId());

    public static final Room ROOM0_DRUGHBA = new Room(200.50, 2, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM1_DRUGHBA = new Room(220.50, 1, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM2_DRUGHBA = new Room(230.50, 3, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM3_DRUGHBA = new Room(240.50, 4, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM4_DRUGHBA = new Room(250.50, 1, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM5_DRUGHBA = new Room(260.50, 2, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM6_DRUGHBA = new Room(270.50, 3, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM7_DRUGHBA = new Room(280.50, 4, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM8_DRUGHBA = new Room(290.50, 2, null, false, HOTEL_DRUGHBA_KIEV.getId());
    public static final Room ROOM9_DRUGHBA = new Room(300.50, 1, null, false, HOTEL_DRUGHBA_KIEV.getId());

    public static final Room ROOM0_APELSIN = new Room(200.50, 2, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM1_APELSIN = new Room(220.50, 1, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM2_APELSIN = new Room(230.50, 3, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM3_APELSIN = new Room(240.50, 4, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM4_APELSIN = new Room(250.50, 1, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM5_APELSIN = new Room(260.50, 2, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM6_APELSIN = new Room(270.50, 3, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM7_APELSIN = new Room(280.50, 4, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM8_APELSIN = new Room(290.50, 2, null, false, HOTEL_APELSIN_CHERKASSY.getId());
    public static final Room ROOM9_APELSIN = new Room(300.50, 1, null, false, HOTEL_APELSIN_CHERKASSY.getId());

    public static final Room ROOM0_OPTIMA = new Room(200.50, 2, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM1_OPTIMA = new Room(220.50, 1, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM2_OPTIMA = new Room(230.50, 3, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM3_OPTIMA = new Room(240.50, 4, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM4_OPTIMA = new Room(250.50, 1, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM5_OPTIMA = new Room(260.50, 2, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM6_OPTIMA = new Room(270.50, 3, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM7_OPTIMA = new Room(280.50, 4, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM8_OPTIMA = new Room(290.50, 2, null, false, HOTEL_OPTIMA_CHERKASSY.getId());
    public static final Room ROOM9_OPTIMA = new Room(300.50, 1, null, false, HOTEL_OPTIMA_CHERKASSY.getId());

    public static final Room ROOM0_DNESTR = new Room(200.50, 2, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM1_DNESTR = new Room(220.50, 1, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM2_DNESTR = new Room(230.50, 3, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM3_DNESTR = new Room(240.50, 4, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM4_DNESTR = new Room(250.50, 1, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM5_DNESTR = new Room(260.50, 2, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM6_DNESTR = new Room(270.50, 3, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM7_DNESTR = new Room(280.50, 4, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM8_DNESTR = new Room(290.50, 2, null, false, HOTEL_DNESTR_LVIV.getId());
    public static final Room ROOM9_DNESTR = new Room(300.50, 1, null, false, HOTEL_DNESTR_LVIV.getId());

    public static final Room ROOM0_GETMAN = new Room(200.50, 2, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM1_GETMAN = new Room(220.50, 1, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM2_GETMAN = new Room(230.50, 3, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM3_GETMAN = new Room(240.50, 4, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM4_GETMAN = new Room(250.50, 1, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM5_GETMAN = new Room(260.50, 2, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM6_GETMAN = new Room(270.50, 3, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM7_GETMAN = new Room(280.50, 4, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM8_GETMAN = new Room(290.50, 2, null, false, HOTEL_GETMAN_LVIV.getId());
    public static final Room ROOM9_GETMAN = new Room(300.50, 1, null, false, HOTEL_GETMAN_LVIV.getId());

    public static void initializeDAOWithTestData(){
        HotelDAOImpl.initialize(new HashSet<>(Arrays.asList(
                HOTEL_DRUGHBA_KIEV, HOTEL_UKRAINA_KIEV, HOTEL_OPTIMA_CHERKASSY,
                HOTEL_APELSIN_CHERKASSY, HOTEL_DNESTR_LVIV, HOTEL_GETMAN_LVIV
        )));

        RoomDAOImpl.initialize(new HashSet<>(Arrays.asList(
                ROOM0_UKRAINA, ROOM1_UKRAINA, ROOM2_UKRAINA, ROOM3_UKRAINA, ROOM4_UKRAINA, ROOM5_UKRAINA, ROOM6_UKRAINA, ROOM7_UKRAINA, ROOM8_UKRAINA, ROOM9_UKRAINA,
                ROOM0_DRUGHBA, ROOM1_DRUGHBA, ROOM2_DRUGHBA, ROOM3_DRUGHBA, ROOM4_DRUGHBA, ROOM5_UKRAINA, ROOM6_DRUGHBA, ROOM7_DRUGHBA, ROOM8_DRUGHBA, ROOM9_DRUGHBA,
                ROOM0_APELSIN, ROOM1_APELSIN, ROOM2_APELSIN, ROOM3_APELSIN, ROOM4_APELSIN, ROOM5_APELSIN, ROOM6_APELSIN, ROOM7_APELSIN, ROOM8_APELSIN, ROOM9_APELSIN,
                ROOM0_OPTIMA, ROOM1_OPTIMA, ROOM2_OPTIMA, ROOM3_OPTIMA, ROOM4_OPTIMA, ROOM5_OPTIMA, ROOM6_OPTIMA, ROOM7_OPTIMA, ROOM8_OPTIMA, ROOM9_OPTIMA,
                ROOM0_DNESTR, ROOM1_DNESTR, ROOM2_DNESTR, ROOM3_DNESTR, ROOM4_DNESTR, ROOM5_DNESTR, ROOM6_DNESTR, ROOM7_DNESTR, ROOM8_DNESTR, ROOM9_DNESTR,
                ROOM0_GETMAN, ROOM1_GETMAN, ROOM2_GETMAN, ROOM3_GETMAN, ROOM4_GETMAN, ROOM5_GETMAN, ROOM6_GETMAN, ROOM7_GETMAN, ROOM8_GETMAN, ROOM9_GETMAN
        )));

        UserDAOImpl.initialize(new HashSet<>());
    }
}
