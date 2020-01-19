package service.impl;

import domain.Car;
import domain.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;
import server.Server;
import server.ServerThreads;
import service.CarService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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
        cars = carRepository.search(cars,search);
    }

    @Override
    public void searchBrandAndModel(Search search) {
        cars = carRepository.searchBrandAndModel(cars,search.getBrandAndModel());
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
}
