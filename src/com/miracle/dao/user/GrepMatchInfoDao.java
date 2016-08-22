package com.miracle.dao.user;

import org.springframework.stereotype.Repository;

import com.miracle.model.user.GrepMatchInfo;
import com.miracle.orm.hibernate.HibernateDao;

@Repository
public class GrepMatchInfoDao extends HibernateDao<GrepMatchInfo, Long> {

}
