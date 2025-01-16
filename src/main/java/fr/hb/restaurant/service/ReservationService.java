package fr.hb.restaurant.service;

import fr.hb.restaurant.model.Reservation;
import fr.hb.restaurant.model.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    private final List<Reservation> reservations = new ArrayList<>(List.of(
            new Reservation(1, 1, 1, LocalDateTime.now().plusDays(1), 4),
            new Reservation(2, 2, 2, LocalDateTime.now().plusDays(2), 2)));

    @Autowired
    private TableService tableService;

    public List<Reservation> findAll() {
        return reservations;
    }

    public Reservation findById(int id) {
        return reservations.stream()
                .filter(reservation -> reservation.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public String save(Reservation reservation) {
        // Vérification de la contrainte
        Table table = tableService.findById(reservation.getTableId());
        if (table == null) {
            return "La table sélectionnée n'existe pas.";
        }
        if (reservation.getNbPersonnes() > table.getNbPlaces()) {
            return "Le nombre de personnes dépasse le nombre de places disponibles pour cette table.";
        }

        // Sauvegarde de la réservation
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

        return null; // Pas d'erreur
    }

    public void delete(int id) {
        reservations.removeIf(reservation -> reservation.getId() == id);
    }
}
