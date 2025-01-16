package fr.hb.restaurant.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Reservation {
    private int id;
    @NotNull(message = "L'ID de la table est obligatoire")
    private int tableId;
    @NotNull(message = "L'ID du client est obligatoire")
    private int clientId;
    @NotNull(message = "La date et l'heure sont obligatoires")
    private LocalDateTime dateHeure;
    @Min(value = 1, message = "Le nombre de personnes doit être au moins 1")
    private int nbPersonnes;

    public Reservation() {
    }

    public Reservation(int id, int tableId, int clientId, LocalDateTime dateHeure, int nbPersonnes) {
        this.id = id;
        this.tableId = tableId;
        this.clientId = clientId;
        this.dateHeure = dateHeure;
        this.nbPersonnes = nbPersonnes;
    }

    // Getters et Setters

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return int return the tableId
     */
    public int getTableId() {
        return tableId;
    }

    /**
     * @param tableId the tableId to set
     */
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    /**
     * @return int return the clientId
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * @return LocalDateTime return the dateHeure
     */
    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    /**
     * @param dateHeure the dateHeure to set
     */
    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    /**
     * @return int return the nbPersonnes
     */
    public int getNbPersonnes() {
        return nbPersonnes;
    }

    /**
     * @param nbPersonnes the nbPersonnes to set
     */
    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    // Formate la date et l'heure pour être compatible avec Thymeleaf
    public String getFormattedDateHeure() {
        if (this.dateHeure == null)
            return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return this.dateHeure.format(formatter);
    }
}
