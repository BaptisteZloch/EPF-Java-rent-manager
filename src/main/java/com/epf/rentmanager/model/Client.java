package com.epf.rentmanager.model;
import java.time.LocalDate;
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate naissance;

    public Client(int id, String nom, String prenom, String email, LocalDate naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.naissance = naissance;
    }

    public Client(int id) {
        this.id = id;
    }

    public Client(String nom, String prenom, String email, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.naissance = naissance;
    }    

    public Client(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }    

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNaissance() {
        return this.naissance;
    }

    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }


    public Client nom(String nom) {
        setNom(nom);
        return this;
    }

    public Client prenom(String prenom) {
        setPrenom(prenom);
        return this;
    }

    public Client email(String email) {
        setEmail(email);
        return this;
    }

    public Client naissance(LocalDate naissance) {
        setNaissance(naissance);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", email='" + getEmail() + "'" +
            ", naissance='" + getNaissance() + "'" +
            "}";
    }
}