package fr.hb.restaurant.service;

import fr.hb.restaurant.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    private final List<Reservation> reservations = new ArrayList<>(List.of(
        new Reservation(1, 1, 1, LocalDateTime.now().plusDays(1), 4),
        new Reservation(2, 2, 2, LocalDateTime.now().plusDays(2), 2)
    ));

    public List<Reservation> findAll() {
        return reservations;
    }

    public Reservation findById(int id) {
        return reservations.stream()
                .filter(reservation -> reservation.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Reservation reservation) {
        if (reservation.getId() == 0) {
            int newId = reservations.stream()
                    .mapToInt(Reservation::getId)
                    .max()
                    .orElse(0) + 1;
            reservation.setId(newId);
            reservations.add(reservation);
        } else {
            Reservation existing = findById(reservation.getId());
            if (existing != null) {
                existing.setTableId(reservation.getTableId());
                existing.setClientId(reservation.getClientId());
                existing.setDateHeure(reservation.getDateHeure());
                existing.setNbPersonnes(reservation.getNbPersonnes());
            }
        }
    }

    public void delete(int id) {
        reservations.removeIf(reservation -> reservation.getId() == id);
    }
}
