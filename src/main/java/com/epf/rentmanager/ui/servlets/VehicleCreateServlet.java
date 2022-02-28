package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet(name = "VehicleCreateServlet", value = "/cars/create")
public class VehicleCreateServlet extends HttpServlet {
   
    @Autowired
    private VehicleService vehicleService;


    @Override
    public void init() {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("My servlet has been initialized");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Vehicle vehicle = new Vehicle(request.getParameter("manufacturer"),request.getParameter("modele"),(byte)Integer.parseInt(request.getParameter("seats")));
                try {
                    vehicleService.create(vehicle);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
        doGet(request, response);
    }
}
