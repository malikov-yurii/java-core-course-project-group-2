package main.model;

public class Hotel extends NamedEntity {

    private String city;

    public Hotel(String hotelName, String city) {
        super(hotelName);
        this.city = city;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + getName() + '\'' +
                ", city='" + city + '\'' +
                ", id='" + getId() + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
