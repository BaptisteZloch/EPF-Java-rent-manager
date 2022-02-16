package com.epf.rentmanager.model;
import java.time.LocalDate;

public class Reservation {
    private int id;
    private int client_id;
    private int vehicule_id;
    private LocalDate debut;
    private LocalDate fin;
}
