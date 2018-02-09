package com.tienda.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.ExceptionMapper;

import com.tienda.resource.UserResource;

@ApplicationPath("/")
public class TiendaApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
	
		Set<Class<?>> classes=new HashSet<Class<?>>();
		
		classes.add(UserResource.class);
		classes.add(TiendaExceptionMapper.class);
		return classes;
	}
}
