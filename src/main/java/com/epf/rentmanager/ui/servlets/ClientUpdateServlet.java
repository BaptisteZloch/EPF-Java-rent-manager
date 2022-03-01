package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.server.ServerErrorException;


@WebServlet(name = "ClientUpdateServlet", urlPatterns = "/users/update")
public class ClientUpdateServlet extends HttpServlet {
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
            long id = Long.parseLong(request.getParameter("id"));
            Optional<Client> client = clientService.findById(id);
            request.setAttribute("user", client.get());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/users/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                Client client = new Client(Integer.parseInt(request.getParameter("id")),request.getParameter("last_name"),request.getParameter("first_name"),request.getParameter("email"),LocalDate.parse(request.getParameter("birthdate"), formatter));
                try {
                    clientService.update(client);
                } catch (ServerErrorException | ServiceException e) {
                    e.printStackTrace();
                }
        response.sendRedirect("/rentmanager/users");  
    }
}
