package main.model;

import java.util.*;

import static main.datasourse.TestData.*;

public class RoomDAOImpl implements AbstractDAO<Room> {

    private final Collection<Room> rooms = new HashSet<>(Arrays.asList(
            ROOM0_UKRAINA, ROOM1_UKRAINA, ROOM2_UKRAINA, ROOM3_UKRAINA, ROOM4_UKRAINA, ROOM5_UKRAINA, ROOM6_UKRAINA, ROOM7_UKRAINA, ROOM8_UKRAINA, ROOM9_UKRAINA,
            ROOM0_DRUGHBA, ROOM1_DRUGHBA, ROOM2_DRUGHBA, ROOM3_DRUGHBA, ROOM4_DRUGHBA, ROOM5_UKRAINA, ROOM6_DRUGHBA, ROOM7_DRUGHBA, ROOM8_DRUGHBA, ROOM9_DRUGHBA,
            ROOM0_APELSIN, ROOM1_APELSIN, ROOM2_APELSIN, ROOM3_APELSIN, ROOM4_APELSIN, ROOM5_APELSIN, ROOM6_APELSIN, ROOM7_APELSIN, ROOM8_APELSIN, ROOM9_APELSIN,
            ROOM0_OPTIMA, ROOM1_OPTIMA, ROOM2_OPTIMA, ROOM3_OPTIMA, ROOM4_OPTIMA, ROOM5_OPTIMA, ROOM6_OPTIMA, ROOM7_OPTIMA, ROOM8_OPTIMA, ROOM9_OPTIMA,
            ROOM0_DNESTR, ROOM1_DNESTR, ROOM2_DNESTR, ROOM3_DNESTR, ROOM4_DNESTR, ROOM5_DNESTR, ROOM6_DNESTR, ROOM7_DNESTR, ROOM8_DNESTR, ROOM9_DNESTR,
            ROOM0_GETMAN, ROOM1_GETMAN, ROOM2_GETMAN, ROOM3_GETMAN, ROOM4_GETMAN, ROOM5_GETMAN, ROOM6_GETMAN, ROOM7_GETMAN, ROOM8_GETMAN, ROOM9_GETMAN
    ));

    @Override
    public Room save(Room object) {
        return null;
    }

    @Override
    public void delete(Room object) {

    }

    @Override
    public void deleteAll(List<Room> list) {

    }

    @Override
    public void saveAll(List<Room> list) {

    }

    @Override
    public List<Room> getList() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Room get(long id) {
        return null;
    }
}
