package domain;

import java.io.Serializable;
import java.util.Date;

public class Search implements Serializable {

    private String brand;
    private String type;
    private Date dateFrom;
    private Date dateTo;
    private int minPrice;
    private int maxPrice;
    public static final long serialVersionUID =3L;

    public Search(String brand, String type, Date dateFrom, Date dateTo, int minPrice, int maxPrice) {
        this.brand = brand;
        this.type = type;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
