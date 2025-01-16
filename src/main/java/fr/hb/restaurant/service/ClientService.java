package fr.hb.restaurant.service;

import fr.hb.restaurant.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private final List<Client> clients = new ArrayList<>(List.of(
        new Client(1, "SadFlower", "Enio", "enio.sadflower@gmail.com", "0612345678", "Homme", "normal"),
        new Client(2, "MACRON", "Brigitte", "brigitte.macron@gmail.com", "0612345679", "Femme", "vip")
    ));

    public List<Client> findAll() {
        return clients;
    }

    public Client findById(int id) {
        return clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Client client) {
        if (client.getId() == 0) {
            int newId = clients.stream()
                    .mapToInt(Client::getId)
                    .max()
                    .orElse(0) + 1;
            client.setId(newId);
            clients.add(client);
        } else {
            Client existing = findById(client.getId());
            if (existing != null) {
                existing.setNom(client.getNom());
                existing.setPrenom(client.getPrenom());
                existing.setEmail(client.getEmail());
                existing.setTelephone(client.getTelephone());
                existing.setGenre(client.getGenre());
                existing.setNiveau(client.getNiveau());
            }
        }
    }

    public void delete(int id) {
        clients.removeIf(client -> client.getId() == id);
    }
}
