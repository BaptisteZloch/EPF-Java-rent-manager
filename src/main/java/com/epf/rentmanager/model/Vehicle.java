package com.epf.rentmanager.model;

public class Vehicle {
    private int id;
    private String constructeur;
    private String modele;
    private byte nb_place;
    private int client_id;


    public Vehicle(int id, String constructeur, String modele, byte nb_place) {
        this.id = id;
        this.constructeur = constructeur;
        this.modele = modele;
        this.nb_place = nb_place;
    }
    public Vehicle(int id) {
        this.id = id;
    }
    
    public Vehicle(String constructeur, String modele, byte nb_place,int client_id) {
        this.constructeur = constructeur;
        this.modele = modele;
        this.nb_place = nb_place;
        this.client_id = client_id;
    }

    public Vehicle(int id, String constructeur, String modele, byte nb_place,int client_id) {
        this.id = id;
        this.constructeur = constructeur;
        this.modele = modele;
        this.nb_place = nb_place;
        this.client_id = client_id;
    }

    public int getId() {
        return this.id;
    }

    public int getClient_id() {
        return this.client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
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