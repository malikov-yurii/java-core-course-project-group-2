package main.model;

public class Hotel extends NamedEntity {

    private String hotelName;

    private String city;

    public Hotel(String hotelName, String city) {
        super(hotelName);
        this.city = city;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
