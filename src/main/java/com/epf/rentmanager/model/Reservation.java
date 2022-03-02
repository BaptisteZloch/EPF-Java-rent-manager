package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private int client_id;
    private int vehicle_id;
    private LocalDate debut;
    private LocalDate fin;

    public Reservation(int id, int client_id, int vehicle_id, LocalDate debut, LocalDate fin) {
        this.id = id;
        this.client_id = client_id;
        this.vehicle_id = vehicle_id;
        this.debut = debut;
        this.fin = fin;
    }

    public Reservation(int id) {
        this.id = id;
    }
    public Reservation(int client_id, int vehicle_id, LocalDate debut, LocalDate fin) {
        this.client_id = client_id;
        this.vehicle_id = vehicle_id;
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

    public int getVehicle_id() {
        return this.vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
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

    public Reservation vehicle_id(int vehicle_id) {
        setVehicle_id(vehicle_id);
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
                ", vehicle_id='" + getVehicle_id() + "'" +
                ", debut='" + getDebut() + "'" +
                ", fin='" + getFin() + "'" +
                "}";
    }
}