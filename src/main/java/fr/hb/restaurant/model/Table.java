package fr.hb.restaurant.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Table {
    private int id;

    @Min(value = 1, message = "Le nombre de places doit être au moins 1")
    private int nbPlaces;
    @NotBlank(message = "Le statut est obligatoire")
    private String statut;

    public Table() {
    }

    public Table(int id, int nbPlaces, String statut) {
        this.id = id;
        this.nbPlaces = nbPlaces;
        this.statut = statut;
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
     * @return int return the nbPlaces
     */
    public int getNbPlaces() {
        return nbPlaces;
    }

    /**
     * @param nbPlaces the nbPlaces to set
     */
    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    /**
     * @return String return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }
}
