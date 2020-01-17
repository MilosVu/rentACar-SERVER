package repository;

import domain.Reservation;

import java.util.Date;
import java.util.GregorianCalendar;

public interface ReservationRepository {

    boolean reserve(Reservation reservation);

    boolean cancel(int reservationID);

    boolean changeDate(int reservationID, Date from, Date to);
}
