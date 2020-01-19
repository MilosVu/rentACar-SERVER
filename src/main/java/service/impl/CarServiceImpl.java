package service.impl;

import domain.Car;
import domain.Search;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;
import server.ServerThreads;
import service.CarService;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private List<Car> cars;

    @Autowired
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
        this.cars = new LinkedList<>();
    }

    @Override
    public void search(Search search) {
        System.out.println("SEARCH!!!!");
        cars = carRepository.search(cars,search);
//        try {
//            for (Car car:
//                    cars) {
//                ServerThreads.objectOutputStream.writeObject(car);
//            }
//            ServerThreads.objectOutputStream.writeObject(null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void load() {
        cars.clear();
        cars = carRepository.load();
    }

    @Override
    public void preview() {
        carRepository.preview(cars);
    }

    @Override
    public void advertisedCars() {
        cars = carRepository.advertisedCars();
        try {
            for (Car car:
                 cars) {
                ServerThreads.objectOutputStream.writeObject(car);
            }
            ServerThreads.objectOutputStream.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void isAvailable(Date from, Date to, List<Car> cars) {
        cars = carRepository.isAvailable(from,to,cars);
    }
}
