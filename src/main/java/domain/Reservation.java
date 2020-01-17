package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Reservation implements Serializable {

    private int ReservationID;
    private String username;
    private int carID;
    private Date pickUpDate;
    private Date returnDate;
    private int price;
    private String done;
    public static final long serialVersionUID =4L;

    public Reservation(int reservationID, String username, int carID, Date pickUpDate, Date returnDate, int price, String done) {
        ReservationID = reservationID;
        this.username = username;
        this.carID = carID;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.price = price;
        this.done = done;
    }

    public Reservation(String username, int carID, Date pickUpDate, Date returnDate, int price, String done) {
        this.username = username;
        this.carID = carID;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.price = price;
        this.done = done;
    }

    public Reservation() {
    }

    public int getReservationID() {
        return ReservationID;
    }

    public void setReservationID(int reservationID) {
        ReservationID = reservationID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
