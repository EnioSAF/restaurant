package fr.hb.restaurant.model;

public class Table {
    private int id;
    private int nbPlaces;
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
