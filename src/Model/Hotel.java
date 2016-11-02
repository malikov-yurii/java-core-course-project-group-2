package Model;

import java.util.Collection;

public class Hotel extends AbstractEntity {

    private String hotelName;

    private String city;

    public Hotel(String hotelName, String city) {
        this.hotelName = hotelName;
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
