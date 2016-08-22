package com.miracle.service.user;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miracle.dao.user.GrepUserInfoDao;
import com.miracle.model.user.GrepUserInfo;
import com.miracle.orm.hibernate.CriteriaExecuteCallBack;
import com.miracle.utils.DateUtil;

@Service("grepUserInfoService")
public class GrepUserInfoService {

	@Autowired
	protected GrepUserInfoDao grepUserInfo;
	
	public GrepUserInfo getGrepUserInfo(final Long id) {
		return grepUserInfo.get(id);
	}
	
	public GrepUserInfo getGrepUserInfo(final String propertyName, final Object value) {
		return grepUserInfo.findUniqueBy(propertyName, value);
	}
	
	public GrepUserInfo saveGrepUserInfo(final GrepUserInfo user) {
		return grepUserInfo.save(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<GrepUserInfo> findCanBuyUser() {
		return (List<GrepUserInfo>)grepUserInfo.execute(new CriteriaExecuteCallBack() {
			public Object execute(Criteria criteria) {
				criteria.add(Restrictions.gt("lastModifyTime", DateUtil.calDate(new Date(),0,0,-7)));
				criteria.addOrder(Order.desc("wonNum").desc("lastModifyTime").desc("wonMoeny"));
				criteria.setMaxResults(50); 
				return criteria.list();
			}
		});
	}
	
	public List<GrepUserInfo> find(final String hql, final Object... values) {
		return grepUserInfo.find(hql,values);
	}
	
	public List findByDetachedCriteria(final DetachedCriteria criteria) {
		return grepUserInfo.findByDetachedCriteria(criteria);
	}
	
	public List findByDetachedCriteria(final DetachedCriteria criteria, int firstResult, int maxResults) {
		return grepUserInfo.findByDetachedCriteria(criteria,firstResult,maxResults);
	}
}
