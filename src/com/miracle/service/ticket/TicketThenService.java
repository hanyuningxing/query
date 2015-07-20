package com.miracle.service.ticket;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.miracle.dao.ticket.TicketDatailDao;
import com.miracle.dao.ticket.TicketPlatformInfoDao;
import com.miracle.dao.ticket.TicketThenDao;
import com.miracle.model.ticket.TicketDatail;
import com.miracle.model.ticket.TicketPlatformInfo;
import com.miracle.model.ticket.TicketThen;
import com.miracle.model.user.User;
import com.miracle.orm.Pagination;
import com.miracle.orm.XDetachedCriteria;
import com.miracle.service.QueryService;

@Service
@Transactional
public class TicketThenService {

	@Autowired
	private QueryService queryService;
	@Autowired
	protected TicketPlatformInfoDao ticketPlatformInfoDao;
	@Autowired
	protected TicketThenDao ticketThenDao;
	@Autowired
	protected TicketDatailDao ticketDatailDao;
	public Pagination findByCriteriaAndPagination(final XDetachedCriteria criteria, final Pagination page) {
		return queryService.findByCriteriaAndPagination(criteria, page);
	}
	public List findByDetachedCriteria(final DetachedCriteria criteria) {
		return queryService.findByDetachedCriteria(criteria);
	}
	public List findByDetachedCriteria(final DetachedCriteria criteria, int firstResult, int maxResults) {
		return queryService.findByDetachedCriteria(criteria,firstResult,maxResults);
	}
	public TicketPlatformInfo getTicketPlatformInfoBy(final User user) {
		if (null==user) {
			return null;
		}
		final List<TicketPlatformInfo> li = ticketPlatformInfoDao.findBy("userId",user.getId());
		if (null != li && !li.isEmpty()) {
			return li.get(0);
		}
		return null;
	}
	public TicketPlatformInfo saveTicketPlatformInfo(final TicketPlatformInfo ticketPlatformInfo) {
		return ticketPlatformInfoDao.save(ticketPlatformInfo);
	}
	public TicketThen getTicketThen(Long id) {
		return ticketThenDao.get(id);
	}
	public TicketDatail getTicketDatailByTicketThen(TicketThen ticketThen) {
		return ticketDatailDao.findUniqueBy("ticketId", ticketThen.getId());
	}
}
