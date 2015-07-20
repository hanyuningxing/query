package com.miracle.dao.ticket;

import org.springframework.stereotype.Repository;

import com.miracle.model.ticket.TicketThen;
import com.miracle.orm.hibernate.HibernateDao;

@Repository
public class TicketThenDao extends HibernateDao<TicketThen, Long> {

}
