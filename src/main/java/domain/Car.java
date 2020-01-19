package domain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Car implements Serializable {

    private int carID;
    private String brand;
    private String model;
    private int year;
    private String transmission;
    private String type;
    private int price;
    private String fuel;
    private int seats;
    private String imageURL;
    public static final long serialVersionUID =1L;

    public Car(int carID, String brand, String model, int year, String transmission, String type, int price, String fuel, int seats, String imageURL) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.transmission = transmission;
        this.type = type;
        this.price = price;
        this.fuel = fuel;
        this.seats = seats;
        this.imageURL = imageURL;
    }

    public Car() {
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String image) {
        this.imageURL = image;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", transmission='" + transmission + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", fuel='" + fuel + '\'' +
                ", seats=" + seats +
                '}';
    }
}
