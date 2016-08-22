package com.miracle.service.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miracle.dao.user.GrepProjectInfoDao;
import com.miracle.model.user.GrepProjectInfo;

@Service("grepProjectInfoService")
public class GrepProjectInfoService {

	@Autowired
	protected GrepProjectInfoDao grepProjectInfo;
	
	public GrepProjectInfo getGrepProjectInfo(final Long id) {
		return grepProjectInfo.get(id);
	}
	public GrepProjectInfo getGrepProjectInfo(final String propertyName, final Object value) {
		return grepProjectInfo.findUniqueBy(propertyName, value);
	}
	
	public GrepProjectInfo saveGrepProjectInfo(final GrepProjectInfo user) {
		return grepProjectInfo.save(user);
	}
	
	public List<GrepProjectInfo> find(final String hql, final Object... values) {
		return grepProjectInfo.find(hql,values);
	}
	public List findByDetachedCriteria(final DetachedCriteria criteria) {
		return grepProjectInfo.findByDetachedCriteria(criteria);
	}
	
	public List findByDetachedCriteria(final DetachedCriteria criteria, int firstResult, int maxResults) {
		return grepProjectInfo.findByDetachedCriteria(criteria,firstResult,maxResults);
	}
}
