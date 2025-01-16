package fr.hb.restaurant.model;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private int tableId;
    private int clientId;
    private LocalDateTime dateHeure;
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
}
