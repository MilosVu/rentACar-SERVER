package service.impl;

import domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReservationRepository;
import service.ReservationService;

import java.util.Date;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public boolean reserve(Reservation reservation) {
        return reservationRepository.reserve(reservation);
    }

    @Override
    public boolean cancel(int reservationID) {
        return reservationRepository.cancel(reservationID);
    }

    @Override
    public boolean changeDate(int reservationID, Date from, Date to) {
        return reservationRepository.changeDate(reservationID, from, to);
    }
}
