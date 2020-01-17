package repository;

import domain.Car;
import domain.Search;

import java.util.List;

public interface CarRepository {

    List<Car> search(List<Car> cars, Search search);

    List<Car> searchBrandAndModel(List<Car> cars, String[][] brandAndModel);

    List<Car> load();

    void preview(List<Car> cars);

    List<Car> advertisedCars();
}
