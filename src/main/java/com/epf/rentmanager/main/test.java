package com.epf.rentmanager.main;

import java.util.ArrayList;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;

public class test {
    public static void main(String[] args) throws ServiceException {
        ArrayList<Client> clientList = ClientService.getInstance().findAll();
        System.out.println(clientList);
    }
}
