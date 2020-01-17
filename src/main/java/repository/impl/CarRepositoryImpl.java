package repository.impl;

import com.sun.org.apache.bcel.internal.generic.Select;
import domain.Car;
import domain.Search;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import repository.CarRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final JdbcTemplate jdbcTemplate;

    public CarRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Car> search(List<Car> cars, Search search) {

        for(int i = 0; i < cars.size(); i++){
            Car car = cars.get(i);
            if(!checkYear(car,search.getYear())){
                cars.remove(i);
                break;
            }
            if(!checkPrice(car,search.getPrice())){
                cars.remove(i);
                break;
            }
            if(!checkFuel(car,search.getFuel())){
                cars.remove(i);
                break;
            }
            if(!checkSeats(car,search.getSeats())){
                cars.remove(i);
                break;
            }
            if(!checkTransmission(car,search.getTransmission())){
                cars.remove(i);
                break;
            }
            if(!checkType(car,search.getType())){
                cars.remove(i);
                break;
            }
        }

        return cars;
    }

    private boolean check(Car car, String[] brandAndModel){
        if(car.getBrand().equals(brandAndModel[0])){
            if(brandAndModel[1] != null) {
                if (car.getModel().equals(brandAndModel[1]))
                    return true;
                else
                    return false;
            }
            else
                return true;

        }
        return false;
    }

    private boolean checkYear(Car car,int[] year){
        if(year != null){
            if((year[0] == -1 || car.getYear() > year[0]) &&
                    (year[1] == -1 || car.getYear() < year[1]))
                return true;
            else
                return false;
        }
        return true;
    }

    private boolean checkTransmission(Car car, String transmission){
        if(transmission != null){
            return car.getTransmission().equals(transmission);
        }
        return true;
    }

    private boolean checkType(Car car,String[] type){
        if(type != null){
            for(String s: type){
                if(car.getType().equals(s))
                    return true;
            }
            return false;
        }
        return true;
    }

    private boolean checkPrice(Car car,int[] price){
        if(price != null){
            if((price[0] == -1 || car.getPrice() > price[0]) &&
                    (price[1] == -1 || car.getPrice() < price[1]))
                return true;
            else
                return false;
        }
        return true;
    }

    private boolean checkFuel(Car car,String fuel){
        if(fuel != null){
            return car.getFuel().equals(fuel);
        }
        return true;
    }

    private boolean checkSeats(Car car,int[] seats){
        if(seats != null){
            if((seats[0] == -1 || car.getSeats() > seats[0]) &&
                    (seats[1] == -1 || car.getSeats() < seats[1]))
                return true;
            else
                return false;
        }
        return true;
    }

    @Override
    public List<Car> searchBrandAndModel(List<Car> cars, String[][] brandAndModel) {
        boolean in = false;
        for (int i = 0; i < cars.size(); i++){
            for (int j = 0; j < brandAndModel.length; j++) {
                if (check(cars.get(i), brandAndModel[j])) {
                    in = true;
                }
            }
            if(in)
                in = false;
            else
                cars.remove(i);
        }
        return cars;
    }

    @Override
    public List<Car> load() {
        return jdbcTemplate.query("SELECT * FROM car",new CarMapper());
    }

    @Override
    public void preview(List<Car> cars) {
        for (Car car:
             cars) {
            System.out.println(car);
        }
    }

    @Override
    public List<Car> advertisedCars() {
        return jdbcTemplate.query("SELECT * FROM car WHERE advrtisment = ?", new Object[]{1},
                new CarMapper());
    }

    class CarMapper implements RowMapper<Car> {

        public Car mapRow(ResultSet rs, int i) throws SQLException {
            Car car = new Car();
            car.setCarID(rs.getInt("carID"));
            car.setBrand(rs.getString("brand"));
            car.setModel(rs.getString("model"));
            car.setYear(rs.getInt("year"));
            car.setTransmission(rs.getString("transmission"));
            car.setType(rs.getString("type"));
            car.setPrice(rs.getInt("price"));
            car.setFuel(rs.getString("fuel"));
            car.setSeats(rs.getInt("seats"));
            return car;
        }
    }

}
