package domain;

import java.io.Serializable;

public class Search implements Serializable {

    private String[][] brandAndModel;
    private int[] year;
    private String transmission;
    private String[] type;
    private int[] price;
    private String fuel;
    private int[] seats;
    public static final long serialVersionUID =3L;

    public Search(String[][] brandAndModel, int[] year, String transmission, String[] type, int[] price, String fuel, int[] seats) {
        this.brandAndModel = brandAndModel;
        this.year = year;
        this.transmission = transmission;
        this.type = type;
        this.price = price;
        this.fuel = fuel;
        this.seats = seats;
    }

    public Search() {
    }

    public String[][] getBrandAndModel() {
        return brandAndModel;
    }

    public void setBrandAndModel(String[][] brandAndModel) {
        this.brandAndModel = brandAndModel;
    }

    public int[] getYear() {
        return year;
    }

    public void setYear(int[] year) {
        this.year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        this.price = price;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int[] getSeats() {
        return seats;
    }

    public void setSeats(int[] seats) {
        this.seats = seats;
    }
}
