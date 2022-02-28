package com.epf.rentmanager.main;

import java.util.ArrayList;
import java.util.Optional;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;

public class test {
    @Autowired
    private VehicleService vehicleService;

    public void gestion() throws ServiceException{
    /*
         * ArrayList<Client> clientList = ClientService.getInstance().findAll();
         * System.out.println(clientList);
         * 
         * 
         * Optional<Client> client = ClientService.getInstance().findById(1);
         * System.out.println(client);
         */

        ArrayList<Vehicle> vehicleList = vehicleService.findAll();
        System.out.println(vehicleList);

        /*
         * Optional<Vehicle> vehicle = VehicleService.getInstance().findById(1);
         * System.out.println(vehicle);
         */

        Vehicle vehicle = new Vehicle("Dacia", "Duster", (byte) 2);
        System.out.println(vehicle);
        vehicleService.create(vehicle);

        ArrayList<Vehicle> vehicleList2 = vehicleService.findAll();
        System.out.println(vehicleList2);
    }

    public static void main(String[] args) throws ServiceException {
        this.gestion();
    }
}
