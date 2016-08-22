package com.miracle.service.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miracle.dao.user.GrepMatchInfoDao;
import com.miracle.model.user.GrepMatchInfo;

@Service("GrepMatchInfoService")
public class GrepMatchInfoService {

	@Autowired
	protected GrepMatchInfoDao grepMatchInfo;
	
	public GrepMatchInfo getGrepMatchInfo(final Long id) {
		return grepMatchInfo.get(id);
	}
	public GrepMatchInfo getGrepMatchInfo(final String propertyName, final Object value) {
		return grepMatchInfo.findUniqueBy(propertyName, value);
	}
	
	public GrepMatchInfo saveGrepMatchInfo(final GrepMatchInfo user) {
		return grepMatchInfo.save(user);
	}
	
	public List<GrepMatchInfo> find(final String hql, final Object... values) {
		return grepMatchInfo.find(hql,values);
	}
	public List findByDetachedCriteria(final DetachedCriteria criteria) {
		return grepMatchInfo.findByDetachedCriteria(criteria);
	}
	
	public List findByDetachedCriteria(final DetachedCriteria criteria, int firstResult, int maxResults) {
		return grepMatchInfo.findByDetachedCriteria(criteria,firstResult,maxResults);
	}
}
