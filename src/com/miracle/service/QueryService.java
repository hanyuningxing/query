package com.miracle.service;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.ResultTransformer;

import com.miracle.orm.Pagination;
import com.miracle.orm.XDetachedCriteria;

public interface QueryService {
	/**
	 * 使用XDetachedCriteria进行分页查询
	 * 
	 * @param criteria 查询封装对象
	 * @param page 分页对象
	 * @return 包含查询结果的分页对象
	 */
	Pagination findByCriteriaAndPagination(XDetachedCriteria criteria, Pagination page);

	/**
	 * 使用HQL查询，支持分页
	 * 
	 * @param queryString hql查询语句
	 * @param paramMap 查询参数MAP
	 * @param page 分页对象
	 * @param transformer 结果转换对象
	 * @return 包含查询结果的分页对象
	 */
	Pagination findByHql(String queryString, Map<String, Object> paramMap, Pagination page,
			ResultTransformer transformer);

	/**
	 * 使用SQL查询，支持分页
	 * 
	 * @param sql SQL查询语句
	 * @param page 分页对象
	 * @param entity 查询的实体class
	 * @return 包含查询结果的分页对象
	 */
	Pagination findBySql(String sql, Pagination page, Class<?> entity);
	
	List findByDetachedCriteria(DetachedCriteria criteria);
	
	public List findByDetachedCriteria(DetachedCriteria criteria, int firstResult, int maxResults) ;
}
