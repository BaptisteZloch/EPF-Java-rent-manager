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
import com.epf.rentmanager.service.ClientService;

@WebServlet(name = "ClientListServlet", urlPatterns = "/users")
public class ClientListServlet extends HttpServlet {
    private ClientService serviceClient;
    @Override
    public void init(ServletConfig config) {
        System.out.println("My servlet has been initialized");
        serviceClient = new ClientService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Client> clientList = serviceClient.findAll();
            request.setAttribute("users", clientList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("./WEB-INF/views/users/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
