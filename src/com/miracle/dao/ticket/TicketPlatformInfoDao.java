package com.miracle.dao.ticket;

import org.springframework.stereotype.Repository;

import com.miracle.model.ticket.TicketPlatformInfo;
import com.miracle.orm.hibernate.HibernateDao;

@Repository
public class TicketPlatformInfoDao extends HibernateDao<TicketPlatformInfo, Long> {

}
