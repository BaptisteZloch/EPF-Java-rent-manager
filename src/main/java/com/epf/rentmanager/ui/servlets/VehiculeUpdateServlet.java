package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet(name = "VehiculeUpdateServlet", value = "/cars/update")
public class VehiculeUpdateServlet extends HttpServlet {
   
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ClientService clientService;


    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("My servlet has been initialized");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", clientService.findAll());
            request.setAttribute("vehicule", vehicleService.findById(Integer.parseInt(request.getParameter("id"))).get());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Vehicle vehicle = new Vehicle(Integer.parseInt(request.getParameter("id")), request.getParameter("manufacturer"),request.getParameter("modele"),(byte)Integer.parseInt(request.getParameter("seats")),Integer.parseInt(request.getParameter("owner")));
                try {
                    vehicleService.update(vehicle);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
        //doGet(request, response);
        response.sendRedirect("/rentmanager/cars");  
    }
}
