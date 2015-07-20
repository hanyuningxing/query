package com.miracle.orm.hibernate;

import org.hibernate.event.spi.SaveOrUpdateEvent;


public interface ExtensionSaveOrUpdateCallBack {

	void run(SaveOrUpdateEvent event);

}
