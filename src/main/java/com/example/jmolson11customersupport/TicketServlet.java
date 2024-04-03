package com.example.jmolson11customersupport;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "tickets", value="/tickets")
public class TicketServlet extends HttpServlet {
   private final Map<Integer, Ticket> ticketMap = new HashMap<>(); //store tickets
   private int nextTicketId = 1;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.setContentType("text/html");

      String action = request.getParameter("action");

      if (action == null) {
          action = "list";
      }

      switch (action) {
          case "createTicket" -> viewTicket(request, response);
          default -> listTicket(request, response);
      }
  }

    private void listTicket(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        //heading and link to create ticket
        out.println("<html><body><h2>Ticket</h2>");
        out.println("<a href=\"ticket?action=createBlog\">Create Ticket</a><br><br>");
    }
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response, int nextTicketId, Object HttpServletResponse) throws ServletException, IOException{
        response.setContentType("text/html");
      String action = request.getParameter("action");
      if (action == null){
          action = "list";
      }
      switch (action){
          case "create" -> createTicket(request, response);
          default -> response.sendRedirect("Ticket");
      }

    protected void viewTicket(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int ticketID = Integer.parseInt(request.getParameter("id"));

  }
  private void createTicket(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      String title = request.getParameter("title");
      String description = request.getParameter("description");
      Part attachmentPart = request.getPart("attachment");
      Ticket newTicket = new Ticket(nextTicketId++, title, description, attachmentPart);
  }
  protected void downloadAttachment(HttpServletRequest request, HttpServletResponse response) throws IOException{

  }
  private Ticket getTicket(int ticketID){
      return ticketMap.get(ticketID);
  }
}
