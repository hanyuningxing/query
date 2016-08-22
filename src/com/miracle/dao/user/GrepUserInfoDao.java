package com.miracle.dao.user;

import org.springframework.stereotype.Repository;

import com.miracle.model.user.GrepUserInfo;
import com.miracle.orm.hibernate.HibernateDao;

@Repository
public class GrepUserInfoDao extends HibernateDao<GrepUserInfo, Long> {

}
