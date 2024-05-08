package com.example.jmolson11customersupport.site;

import com.example.jmolson11customersupport.entities.TicketEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultTicketRepository extends GenericJpaRepository<Long, TicketEntity> implements TicketRepository {

}

