package repository.impl;

import domain.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import repository.ReservationRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReservationRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean reserve(Reservation reservation) {
        try {
            jdbcTemplate.update("INSERT INTO reservation VALUES (?,?,?,?,?,?,?)",null, reservation.getUsername(),reservation.getCarID(),
                    reservation.getPickUpDate(),reservation.getReturnDate(),reservation.getPrice(),null);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error trying to add new reservation");
            return false;
        }
        return true;
    }

    @Override
    public boolean cancel(int reservationID) {
        try {
            jdbcTemplate.update("DELETE FROM reservation WHERE reservationID = ?",reservationID);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error trying to cancel reservation");
            return false;
        }
        return true;
    }

    @Override
    public boolean changeDate(int reservationID, Date from, Date to) {
        try {
            jdbcTemplate.update("UPDATE reservation SET pickUpDate = ?, returnDate = ? WHERE reservationID = ?",from,to,reservationID);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error trying to cancel reservation");
            return false;
        }
        return true;
    }

    class ReservationMapper implements RowMapper<Reservation> {

        public Reservation mapRow(ResultSet rs, int i) throws SQLException {
            Reservation reservation = new Reservation();
            reservation.setReservationID(rs.getInt("reservationID"));
            reservation.setUsername(rs.getString("username"));
            reservation.setCarID(rs.getInt("carID"));
            reservation.setPickUpDate(rs.getDate("pickUpDate"));
            reservation.setReturnDate(rs.getDate("returnDate"));
            return reservation;
        }
    }

}
