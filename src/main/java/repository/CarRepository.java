package repository;

import domain.Car;
import domain.Search;

import java.util.Date;
import java.util.List;

public interface CarRepository {

    List<Car> search(List<Car> cars, Search search);

    List<Car> load();

    void preview(List<Car> cars);

    List<Car> advertisedCars();

    boolean isAvailable (Date from, Date to, Car car);

}
