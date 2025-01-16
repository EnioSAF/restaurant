package fr.hb.restaurant.service;

import fr.hb.restaurant.model.Table;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    private final List<Table> tables = new ArrayList<>(List.of(
            new Table(1, 4, "disponible"),
            new Table(2, 6, "reservée"),
            new Table(3, 2, "en entretien")));

    public List<Table> findAll() {
        return tables;
    }

    public Table findById(int id) {
        return tables.stream()
                .filter(table -> table.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Table table) {
        if (table.getId() == 0) {
            int newId = tables.stream()
                    .mapToInt(Table::getId)
                    .max()
                    .orElse(0) + 1;
            table.setId(newId);
            tables.add(table);
        } else {
            Table existing = findById(table.getId());
            if (existing != null) {
                existing.setNbPlaces(table.getNbPlaces());
                existing.setStatut(table.getStatut());
            }
        }
    }

    public void delete(int id) {
        tables.removeIf(table -> table.getId() == id);
    }
}
