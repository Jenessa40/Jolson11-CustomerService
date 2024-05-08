package com.example.jmolson11customersupport.site;

import com.example.jmolson11customersupport.Ticket;
import com.example.jmolson11customersupport.entities.TicketEntity;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTicketService implements TicketService {

    @Inject
    TicketRepository ticketRepo;

    @Override
    @Transactional
    public List<Ticket> getAllBlogs() {
        List<Ticket> list = new ArrayList<>();
        ticketRepo.getAll().forEach(e -> list.add(this.convert(e)));
        return list;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    @Override
    public Ticket getTicket(long id) {
        TicketEntity entity = ticketRepo.get(id);
        return entity == null ? null : this.convert(entity);
    }

    private Ticket convert(TicketEntity entity) {
        Ticket ticket = new Ticket();
        ticket.setId(entity.getId());
        ticket.setTitle(entity.getTitle());
        ticket.setBody(entity.getBody());
        ticket.setDate(entity.getDateCreated().toLocalDateTime().toLocalDate());

        return ticket;
    }

    @Override
    @Transactional
    public void save(Ticket ticket) {
        // convert from blog -> blogentity
        TicketEntity entity = new TicketEntity();
        entity.setId(ticket.getId());
        entity.setTitle(ticket.getTitle());
        entity.setBody(ticket.getBody());

        if (ticket.getId() < 1) { // doesn't have an id which means not updating
            entity.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
            // add to the repo
            ticketRepo.add(entity);
            ticket.setId(entity.getId()); // get the id from the entity to use in the Controller to actually view the blog

        }
        else { // just editing the blog so update it on the DB
            ticketRepo.update(entity);
        }

    }

    @Override
    public void deleteTicket(long id) {

    }

    @Override
    @Transactional
    public void deleteTickdet(long id) {
        ticketRepo.deleteById(id);
    }


}

