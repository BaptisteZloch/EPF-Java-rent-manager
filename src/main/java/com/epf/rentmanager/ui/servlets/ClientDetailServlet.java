package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;

@WebServlet(name = "ClientDetailServlet", urlPatterns = "/users/details")
public class ClientDetailServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) {
        System.out.println("My servlet has been initialized");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long id = Long.parseLong(request.getParameter("id"));
            Optional<Client> client = ClientService.getInstance().findById(id);
            request.setAttribute("user", client);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/users/details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
