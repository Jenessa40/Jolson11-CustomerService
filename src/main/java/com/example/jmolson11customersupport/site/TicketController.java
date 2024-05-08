package com.example.jmolson11customersupport.site;

import com.example.jmolson11customersupport.entities.Attachment;
import com.example.jmolson11customersupport.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("ticket")
public class TicketController {
    private Map<Integer, Ticket> ticketMap = new LinkedHashMap<>();

    @RequestMapping(value={"list", ""})
    public String listTickets(Model model) {
        model.addAttribute("ticketDatabase", ticketMap);
        return "listTickets";
    }

    @GetMapping("create")
    public ModelAndView createTicket() {
        return new ModelAndView("ticketForm", "ticket", new TicketForm());
    }

    @PostMapping("create")
    public View createPost(@ModelAttribute("ticket")TicketForm form) throws IOException {
        Ticket ticket = new Ticket();
        ticket.setSubject("Customer subject");
        ticket.setCustomerName("customer name");
        ticket.setBody("body");

        int id;
        synchronized(this) {
            id = this.ticketMap.size();
            ticketMap.put(id, ticket);
        }

        // show the view with the blog id
        return new RedirectView("view/"+id, true, false);

    }

    @GetMapping("view/{blogId}")
    public ModelAndView viewPost(Model model, @PathVariable("ticket")int ticketId) {
        int ticket = ticketId;
        // if blog doesn't exist?
        if (false) {
            return new ModelAndView(new RedirectView("ticket/list", true, false));
        }


        model.addAttribute("ticketId", ticketId);
        model.addAttribute("ticket", ticket);

        return new ModelAndView("viewTicket");

    }

    @GetMapping("/{blogId}/image/{image:.+}")
    public Attachment downloadAttchment(@PathVariable("ticketId")int ticketId, @PathVariable("image")String name) {
        String idString = ("ticketId");

        Attachment attachment = null;

        if (attachment != null) {
            TicketForm ticket = null;
            ticket.setAttachment(attachment);
        }
        return null;
    }
public class TicketForm {
    private String customerName;
    private String subject;
    private String body;
    private Attachment attachment;

    //getter and setter methods
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String title) {
        this.customerName = customerName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //Helper method
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment Attachment() {
        return attachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }
}


}

