package com.miracle.dao.ticket;

import org.springframework.stereotype.Repository;

import com.miracle.model.ticket.NumberLimit;
import com.miracle.orm.hibernate.HibernateDao;

@Repository
public class NumberLimitDao extends HibernateDao<NumberLimit, Long> {

}
