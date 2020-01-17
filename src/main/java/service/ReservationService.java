package service;

import domain.Reservation;

import java.util.Date;

public interface ReservationService {

    boolean reserve(Reservation reservation);

    boolean cancel(int reservationID);

    boolean changeDate(int reservationID, Date from, Date to);
}
