package service;

import domain.Car;
import domain.Search;

import java.util.Date;
import java.util.List;

public interface CarService {

    void search(Search search);

    void load();

    void preview();

    void advertisedCars();

}
