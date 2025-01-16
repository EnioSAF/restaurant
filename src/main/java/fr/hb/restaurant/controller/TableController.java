package fr.hb.restaurant.controller;

import fr.hb.restaurant.model.Table;
import fr.hb.restaurant.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public String getAllTables(Model model) {
        model.addAttribute("tables", tableService.findAll());
        return "tables";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("table", new Table());
        return "add-table";
    }

    @PostMapping("/add")
    public String addTable(@ModelAttribute Table table) {
        tableService.save(table);
        return "redirect:/tables";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Table table = tableService.findById(id);
        if (table != null) {
            model.addAttribute("table", table);
            return "edit-table";
        }
        return "redirect:/tables";
    }

    @PostMapping("/edit")
    public String editTable(@ModelAttribute Table table) {
        tableService.save(table);
        return "redirect:/tables";
    }

    @GetMapping("/delete/{id}")
    public String deleteTable(@PathVariable int id) {
        tableService.delete(id);
        return "redirect:/tables";
    }
}
