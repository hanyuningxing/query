package com.miracle.orm.hibernate;

import org.hibernate.Criteria;

public interface CriteriaExecuteCallBack {

	Object execute(Criteria criteria);

}
