package com.example.examen;

public class clsPlace {

    private int id;
    private String adresse,statut,plaque_immatriculation;

    public clsPlace(int id, String adresse, String statut, String plaque_immatriculation) {
        this.id = id;
        this.adresse = adresse;
        this.statut = statut;
        this.plaque_immatriculation = plaque_immatriculation;
    }

    public String getPlaque_immatriculation() {
        return plaque_immatriculation;
    }

    public void setPlaque_immatriculation(String plaque_immatriculation) {
        this.plaque_immatriculation = plaque_immatriculation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
