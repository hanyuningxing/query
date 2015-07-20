package com.miracle.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miracle.orm.Pagination;
import com.miracle.orm.XDetachedCriteria;
import com.miracle.service.QueryService;
import com.miracle.utils.SQLUtil;

@Service("queryService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class QueryServiceImpl implements QueryService {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Pagination findByCriteriaAndPagination(final XDetachedCriteria criteria, final Pagination page) {
		Criteria c = criteria.getExecutableCriteria(getSession());
		if (criteria.isCacheable()) {
			c.setCacheable(true);
			if (StringUtils.isNotBlank(criteria.getCacheRegion())) {
				c.setCacheRegion(criteria.getCacheRegion());
			}
		}
		if (page.isAutoCount()) {
			c.setProjection(Projections.rowCount());
			final Long total = (Long) c.uniqueResult();
			System.out.println("lo..>>>" + total);
			page.setTotalCount((total != null) ? total.intValue() : 0);
		}
		c = criteria.fillSetting(c);
		if (page.getFirst() >= 0) {
			c.setFirstResult(page.getFirst());
		}
		if (page.getPageSize() > 0) {
			c.setMaxResults(page.getPageSize());
		}
		if (page.getTotalCount() > 0) {
			page.setResult(c.list());
		}
		return page;
	}

	@Override
	public Pagination findByHql(final String queryString, final Map<String, Object> paramMap, final Pagination page,
			final ResultTransformer transformer) {
		final Query query = getSession().createQuery(queryString);// 创建查询对象
		if (paramMap != null && paramMap.size() > 0) {
			query.setProperties(paramMap);// 设置查询参数
		}
		if (page != null) {
			if (page.isAutoCount()) {
				final Query countQuery = getSession().createQuery(SQLUtil.getCountHql(queryString));
				if (paramMap != null && paramMap.size() > 0) {
					countQuery.setProperties(paramMap);// 设置查询参数
				}
				final Object totalCount = countQuery.uniqueResult();
				page.setTotalCount((totalCount != null) ? Integer.parseInt(totalCount.toString()) : 0);
				if (page.getTotalCount() == 0) {
					return page;
				}
			}
			if (page.getFirst() >= 0) {
				query.setFirstResult(page.getFirst());
			}
			if (page.getPageSize() > 0) {
				query.setMaxResults(page.getPageSize());
			}
		}
		if (transformer != null) {
			query.setResultTransformer(transformer);// 设置查询结果的类型
		}
		page.setResult(query.list());
		return page;
	}

	@Override
	public Pagination findBySql(final String sql, final Pagination page, final Class<?> entity) {
		final SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(entity);
		if (page != null) {
			if (page.isAutoCount()) {
				final SQLQuery countQuery = getSession().createSQLQuery(SQLUtil.getCountHql(sql));
				final Object totalCount = countQuery.uniqueResult();
				page.setTotalCount((totalCount != null) ? Integer.parseInt(totalCount.toString()) : 0);
				if (page.getTotalCount() == 0) {
					return page;
				}
			}
			if (page.getFirst() >= 0) {
				query.setFirstResult(page.getFirst());
			}
			if (page.getPageSize() > 0) {
				query.setMaxResults(page.getPageSize());
			}
		}
		page.setResult(query.list());
		return page;
	}
	public List findByDetachedCriteria(DetachedCriteria criteria) {
		return findByDetachedCriteria(criteria, -1, -1);
	}

	public List findByDetachedCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		Criteria c = criteria.getExecutableCriteria(this.getSession());
		if (firstResult >= 0) {
			c.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			c.setMaxResults(maxResults);
		}
		return c.list();
	}

}
