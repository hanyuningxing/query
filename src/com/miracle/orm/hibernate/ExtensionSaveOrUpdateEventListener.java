package com.miracle.orm.hibernate;

import org.hibernate.event.spi.SaveOrUpdateEvent;

public interface ExtensionSaveOrUpdateEventListener {

	ExtensionSaveOrUpdateCallBack preSaveOrUpdate(SaveOrUpdateEvent event);
}
