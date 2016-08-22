package com.miracle.dao.user;

import org.springframework.stereotype.Repository;

import com.miracle.model.user.GrepProjectInfo;
import com.miracle.orm.hibernate.HibernateDao;

@Repository
public class GrepProjectInfoDao extends HibernateDao<GrepProjectInfo, Long> {

}
