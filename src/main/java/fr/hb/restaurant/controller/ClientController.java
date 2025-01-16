package fr.hb.restaurant.controller;

import fr.hb.restaurant.model.Client;
import fr.hb.restaurant.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "clients/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "clients/form";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("client", client);
            return "clients/form";
        }
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Client client = clientService.findById(id);
        if (client != null) {
            model.addAttribute("client", client);
            return "clients/form";
        }
        return "redirect:/clients";
    }

    @PostMapping("/edit")
    public String editClient(@ModelAttribute @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("client", client);
            return "clients/form";
        }
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable int id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
