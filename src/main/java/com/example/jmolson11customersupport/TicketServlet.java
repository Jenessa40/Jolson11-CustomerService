package com.example.jmolson11customersupport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "tickets", value="/tickets")
@MultipartConfig(fileSizeThreshold = 5_242_880, maxFileSize = 20_971_520L, maxRequestSize = 41_943_040L)
class TicketServlet<Attachments> extends HttpServlet {
    private Map<Integer, Ticket> ticketMap; // Store tickets

    @Override
    public void init() throws ServletException {
        ticketMap = new HashMap<>(); // Initialize the hash map
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }
        switch(action) {
            case "createTicket" -> createTicket(request, response);
            case "viewTicker" -> viewTicket(request, response);
            case "downloadAttachment" -> downloadAttachment(request, response);
            default -> listTickets(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null){
            switch (action){
                case "createTicket":
                    createTicket(request, response);
                    break;
                case "processAttachment":
                    processAttachment(request, response);
                    break;
                default:
                    response.getWriter().write("Invalid action");
            }

        }
    }


    private void listTickets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ticketDatabase, ticketDB");
        req.getRequestDispatcher("WEB-INF/jsp/view.listTickets.jsp").forward(req, resp);
    }

    private void viewTicket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String idString = req.getParameter("ticketId");
       req.getAttribute("Ticket,ticket");
       req.getRequestDispatcher("WEB-INF/jsp/view/viewTicket.jsp");
        /* String idString = req.getParameter("ticket");

        PrintWriter out = resp.getWriter();
        out.println("<html><body><h2>ticket</h2>");
        PrintWriter printf = out.printf("<h3>%s</h3>%n", ticketMap());
        out.println("<p>Ticket: " + ticketMap() + "</p>");
        out.println("<p>" + ticketMap() + "</p>");

        out.println("<a href=\"ticket\">Return ticket</a>");
        out.println("</body></html>");

    }

    private Object ticketMap() {
        return null;*/
    }

    private void createTicket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(req.getParameter("customer name"));
        ticket.setBody(req.getParameter("body"));


        int id;
        synchronized(this) {
            id = this.ticketMap.size();
            ticketMap.put(id, ticket);
        }

        //System.out.println(blog);  // see what is in the blog object
        resp.sendRedirect("ticket?action=view&ticket=" + id);
    }

    private void downloadAttachment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("ticket");

        Ticket ticket = getTicket(idString, resp);

        String name = req.getParameter("image");
        if (name == null) {
            resp.sendRedirect("ticket?action=view&ticketId=" + idString);
        }

        Attachments attachments = (Attachments) ticket.getAllAttachements();
        if (attachments == null) {
            resp.sendRedirect("ticket?action=view&ticketId=" + idString);
            return;
        }
    }

    private Ticket getTicket(String idString, HttpServletResponse resp) throws IOException {
        if (idString == null || idString.length() == 0) {
            resp.sendRedirect("ticket");
            return null;
        }

        // find in the 'database' otherwise return null
        try {
            int id = Integer.parseInt(idString);
            Ticket ticket = ticketMap.get(id);
            if (ticket == null) {
                resp.sendRedirect("ticket");
                return null;
            }
            return ticket;
        }
        catch(Exception e) {
            resp.sendRedirect("ticket");
            return null;
        }
    }

    private Attachment processAttachment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream in = Ticket.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // processing the binary data to bytes
        int read;
        final byte[] bytes = new byte[1024];
        while ((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }

        Attachment attachment = new Attachment();
        attachment.setName(Ticket.getSubmittedFileName());
        attachment.setContents(out.toByteArray());

        Attachment attachments = new Attachment();
        return attachments;
    }

    private Ticket getTicket(int ticketId) {
        return null;
    }
    private void showPostForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("WEB-INF/jsp/view/ticketForm.jsp").forward(req, resp);
        /*
        out.println("<html><body><h2>Ticket</h2>");
        out.println("<form method=\"Ticket\" action=\"blog\" enctype=\"multipart/form-data\">");
        out.println("<input type=\"hidden\" name=\"action\" value=\"create\">");
        out.println("Title:<br>");
        out.println("<input type=\"text\" name=\"title\"><br><br>");
        out.println("Body:<br>");
        out.println("<textarea name=\"body\" rows=\"25\" cols=\"100\"></textarea><br><br>");
        out.println("<b>Image</b><br>");
        out.println("<input type=\"file\" name=\"file1\"><br><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form></body></html>");*/

    }
}

