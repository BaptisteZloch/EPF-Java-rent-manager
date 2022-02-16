package com.epf.rentmanager.model;

public class Vehicle {
    private int id;
    private String constructeur;
    private String modele;
    private byte nb_place;


    public Vehicle(int id, String constructeur, String modele, byte nb_place) {
        this.id = id;
        this.constructeur = constructeur;
        this.modele = modele;
        this.nb_place = nb_place;
    }

    public int getId() {
        return this.id;
    }

    public String getConstructeur() {
        return this.constructeur;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public String getModele() {
        return this.modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public byte getNb_place() {
        return this.nb_place;
    }

    public void setNb_place(byte nb_place) {
        this.nb_place = nb_place;
    }

    public Vehicle constructeur(String constructeur) {
        setConstructeur(constructeur);
        return this;
    }

    public Vehicle modele(String modele) {
        setModele(modele);
        return this;
    }

    public Vehicle nb_place(byte nb_place) {
        setNb_place(nb_place);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", constructeur='" + getConstructeur() + "'" +
            ", modele='" + getModele() + "'" +
            ", nb_place='" + getNb_place() + "'" +
            "}";
    }
}