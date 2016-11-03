package main.model;

public class Hotel extends NamedEntity {

    private String city;

    public Hotel(String hotelName, String city) {
        super(hotelName);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
