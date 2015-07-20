package com.miracle.orm.hibernate;

import org.hibernate.Session;

public interface ExecuteCallBack {

	Object execute(Session session);
}
