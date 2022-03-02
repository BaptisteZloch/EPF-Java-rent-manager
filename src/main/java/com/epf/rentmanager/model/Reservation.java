package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private int client_id;
    private int vehicule_id;
    private LocalDate debut;
    private LocalDate fin;

    public Reservation(int id, int client_id, int vehicule_id, LocalDate debut, LocalDate fin) {
        this.id = id;
        this.client_id = client_id;
        this.vehicule_id = vehicule_id;
        this.debut = debut;
        this.fin = fin;
    }

    public Reservation(int id) {
        this.id = id;
    }
    public Reservation(int client_id, int vehicule_id, LocalDate debut, LocalDate fin) {
        this.client_id = client_id;
        this.vehicule_id = vehicule_id;
        this.debut = debut;
        this.fin = fin;
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

    public int getVehicule_id() {
        return this.vehicule_id;
    }

    public void setVehicule_id(int vehicule_id) {
        this.vehicule_id = vehicule_id;
    }

    public LocalDate getDebut() {
        return this.debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return this.fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public Reservation client_id(int client_id) {
        setClient_id(client_id);
        return this;
    }

    public Reservation vehicule_id(int vehicule_id) {
        setVehicule_id(vehicule_id);
        return this;
    }

    public Reservation debut(LocalDate debut) {
        setDebut(debut);
        return this;
    }

    public Reservation fin(LocalDate fin) {
        setFin(fin);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", client_id='" + getClient_id() + "'" +
                ", vehicule_id='" + getVehicule_id() + "'" +
                ", debut='" + getDebut() + "'" +
                ", fin='" + getFin() + "'" +
                "}";
    }
}