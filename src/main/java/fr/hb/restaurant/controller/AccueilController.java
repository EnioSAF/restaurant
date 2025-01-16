package fr.hb.restaurant.controller;

import fr.hb.restaurant.service.ReservationService;
import fr.hb.restaurant.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @Autowired
    private TableService tableService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    public String getAccueil(Model model) {
        long tablesDisponibles = tableService.findAll().stream()
                .filter(table -> "disponible".equalsIgnoreCase(table.getStatut()))
                .count();

        var reservationsDuJour = reservationService.findAll().stream()
                .filter(reservation -> reservation.getDateHeure().toLocalDate().equals(java.time.LocalDate.now()))
                .toList();

        model.addAttribute("pageTitle", "Accueil");
        model.addAttribute("tablesDisponibles", tablesDisponibles);
        model.addAttribute("reservationsDuJour", reservationsDuJour);

        return "accueil";
    }
}
