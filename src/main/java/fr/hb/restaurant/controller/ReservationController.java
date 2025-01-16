package fr.hb.restaurant.controller;

import fr.hb.restaurant.model.Reservation;
import fr.hb.restaurant.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", reservationService.findAll());
        return "reservations/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservations/form";
    }

    @PostMapping("/add")
    public String addReservation(@ModelAttribute @Valid Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("reservation", reservation);
            return "reservations/form";
        }
        reservationService.save(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Reservation reservation = reservationService.findById(id);
        if (reservation != null) {
            model.addAttribute("reservation", reservation);
            return "reservations/form";
        }
        return "redirect:/reservations";
    }

    @PostMapping("/edit")
    public String editReservation(@ModelAttribute @Valid Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("reservation", reservation);
            return "reservations/form";
        }
        reservationService.save(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable int id) {
        reservationService.delete(id);
        return "redirect:/reservations";
    }
}
