package com.miracle.spring;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.miracle.orm.hibernate.CreateMarkable;
import com.miracle.orm.hibernate.UpdateMarkable;

public class ApplicationContextListener implements ApplicationContextAware {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 EventListenerRegistry registry  = ((SessionFactoryImpl)sessionFactory).getServiceRegistry().getService(EventListenerRegistry.class);  
		 registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(new PreInsertEventListener() {
			
			@Override
			public boolean onPreInsert(PreInsertEvent event) {
				if(event.getEntity() instanceof CreateMarkable){
					((CreateMarkable)event.getEntity()).setCreateTime(new Date());
				}
				return false;
			}
		}); 
		 
		 registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(new PreUpdateEventListener() {
				
				@Override
				public boolean onPreUpdate(PreUpdateEvent event) {
					if(event.getEntity() instanceof UpdateMarkable){
						((UpdateMarkable)event.getEntity()).setLastModifyTime(new Date());
					}
					return false;
				}
			});
	}

}
