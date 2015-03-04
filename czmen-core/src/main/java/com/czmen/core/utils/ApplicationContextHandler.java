package com.czmen.core.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ApplicationContext 常量类。
 * @author YANGYONG
 *
 */
public final class ApplicationContextHandler {
	private static class Nested{
		private static final String[] configLocations = new String[]{Constants.ApplicationContextPath};
		private static final ApplicationContext context= new ClassPathXmlApplicationContext(configLocations);
	}
	
	/**
	 * @return
	 */
    public static ApplicationContext getContext() {
    	return Nested.context;
    }
    
    public static ApplicationContext init(){
    	return Nested.context;
    }
}
