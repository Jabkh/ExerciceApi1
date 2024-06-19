package org.example.exerciceapi.model;


public class Voiture {
    private int id;
    private String marque;
    private int anneeDeFabrication;
    private String couleur;

    public Voiture() {}

    public Voiture(int id, String marque, int anneeDeFabrication, String couleur) {
        this.id = id;
        this.marque = marque;
        this.anneeDeFabrication = anneeDeFabrication;
        this.couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getAnneeDeFabrication() {
        return anneeDeFabrication;
    }

    public void setAnneeDeFabrication(int anneeDeFabrication) {
        this.anneeDeFabrication = anneeDeFabrication;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", anneeDeFabrication=" + anneeDeFabrication +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
