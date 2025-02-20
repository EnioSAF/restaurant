package fr.hb.restaurant.controller;

import fr.hb.restaurant.model.Table;
import fr.hb.restaurant.service.TableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public String getAllTables(Model model) {
        model.addAttribute("tables", tableService.findAll());
        return "tables/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Table table = new Table();
        model.addAttribute("table", table);
        model.addAttribute("action", "add");
        return "tables/form";
    }

    @PostMapping("/add")
    public String addTable(@ModelAttribute @Valid Table table, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "add");
            return "tables/form";
        }
        tableService.save(table);
        return "redirect:/tables";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Table table = tableService.findById(id);
        if (table != null) {
            model.addAttribute("table", table);
            model.addAttribute("action", "edit");
            return "tables/form";
        }
        return "redirect:/tables";
    }

    @PostMapping("/edit")
    public String editTable(@ModelAttribute @Valid Table table, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "edit");
            return "tables/form";
        }
        tableService.save(table);
        return "redirect:/tables";
    }

    @GetMapping("/delete/{id}")
    public String deleteTable(@PathVariable int id) {
        tableService.delete(id);
        return "redirect:/tables";
    }
}
