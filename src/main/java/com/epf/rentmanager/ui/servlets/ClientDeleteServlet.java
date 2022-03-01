package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

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

@WebServlet(name = "ClientDeleteServlet", urlPatterns = "/users/delete")
public class ClientDeleteServlet extends HttpServlet {
    @Autowired
    private ClientService clientService;


    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Client client = new Client((int)Long.parseLong(request.getParameter("id")));
        try {
            clientService.delete(client);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        //request.getServletContext().getRequestDispatcher("/WEB-INF/views/users/list.jsp").forward(request, response);
        response.sendRedirect("/rentmanager/users"); 
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
                //request.getParameter("url");
        doGet(request, response);
    }
}
