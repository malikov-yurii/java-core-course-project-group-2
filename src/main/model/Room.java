package main.model;

public class Room extends AbstractEntity {

    private double price;

    private int persons;

    private User userReserved;

    private boolean isReserved;

    private long hotelId;

    public Room(double price, int persons, User userReserved, boolean isReserved, long hotelId) {
        this.price = price;
        this.persons = persons;
        this.userReserved = userReserved;
        this.isReserved = isReserved;
        this.hotelId = hotelId;

    }

    @Override
    public String toString() {
        return "Room{" +
                "price=" + price +
                ", persons=" + persons +
                ", room ID=" + getId() +
                ", hotelId=" + hotelId +
                '}';
    }

    public long getHotelId() {
        return hotelId;
    }

    public static int gett(){return 1;}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public User getUserReserved() {
        return userReserved;
    }

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
