package com.example.jmolson11customersupport.site;

import com.example.jmolson11customersupport.Ticket;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface TicketService {

    @Transactional
    List<Ticket> getAllBlogs();

    @NonNull
    List<Ticket> getAllTickets();
    Ticket getTicket(long id);
    void save(Ticket ticket);
    void deleteTicket(long id);

    @Transactional
    void deleteTickdet(long id);
}
