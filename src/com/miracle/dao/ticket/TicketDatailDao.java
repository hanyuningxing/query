package com.miracle.dao.ticket;

import org.springframework.stereotype.Repository;

import com.miracle.model.ticket.TicketDatail;
import com.miracle.orm.hibernate.HibernateDao;

/**
 * 标准DAO
 * 
 */
@Repository
public class TicketDatailDao extends HibernateDao<TicketDatail, Long> {
	
}
