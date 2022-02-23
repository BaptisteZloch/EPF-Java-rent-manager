package com.epf.rentmanager.main;

import java.util.ArrayList;
import java.util.Optional;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

public class test {
    public static void main(String[] args) throws ServiceException {
        /*ArrayList<Client> clientList = ClientService.getInstance().findAll();
        System.out.println(clientList);


        Optional<Client> client = ClientService.getInstance().findById(1);
        System.out.println(client);*/

        ArrayList<Vehicle> vehicleList = VehicleService.getInstance().findAll();
        System.out.println(vehicleList);

        Optional<Vehicle> vehicle = VehicleService.getInstance().findById(1);
        System.out.println(vehicle);
    }
}
