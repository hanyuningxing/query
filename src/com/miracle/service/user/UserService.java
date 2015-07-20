package com.miracle.service.user;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miracle.dao.ticket.TicketPlatformInfoDao;
import com.miracle.dao.user.UserDao;
import com.miracle.model.ticket.TicketPlatformInfo;
import com.miracle.model.user.User;

@Service("userService")
public class UserService {

	@Autowired
	protected UserDao userDao;
	public User getUser(final Long id) {
		return userDao.get(id);
	}

	public User getUserBy(final String userName) {
		if (StringUtils.isBlank(userName)) {
			return null;
		}
		final List<User> li = userDao.findBy("userName", userName.trim());
		if (null != li && !li.isEmpty()) {
			return li.get(0);
		}
		return null;
	}
	
	public User saveUser(final User user) {
		return userDao.save(user);
	}
}
