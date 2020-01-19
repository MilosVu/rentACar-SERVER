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
import java.util.Date;
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
            if(search.getBrand() != null && !(search.getBrand().equals(car.getBrand())))
                cars.remove(i);

            if(search.getType() != null && !(search.getType().equals(car.getType())))
                cars.remove(i);

            if(search.getMinPrice() > car.getPrice() || search.getMaxPrice() < car.getPrice())
                cars.remove(i);
        }

        return isAvailable(search.getDateFrom(),search.getDateTo(),cars);
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

    @Override
    public List<Car> isAvailable(Date from, Date to, List<Car> cars) {
        return null;
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
            car.setImageURL(rs.getString("url"));
            return car;
        }
    }

}
