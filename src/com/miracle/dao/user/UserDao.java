package com.miracle.dao.user;

import org.springframework.stereotype.Repository;
import com.miracle.model.user.User;
import com.miracle.orm.hibernate.HibernateDao;

@Repository
public class UserDao extends HibernateDao<User, Long> {

}
