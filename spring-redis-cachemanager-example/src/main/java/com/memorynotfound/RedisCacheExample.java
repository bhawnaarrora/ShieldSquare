package com.memorynotfound;

import java.util.Map;

import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.ehcache.Cache;

public class RedisCacheExample {

	public static void main(String[] args) {

		/* load the appconfig file */
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		CachingService cachingService = ctx.getBean(CachingService.class);

		Employee person2 = new Employee();
		person2.setId("6");
		person2.setAge(60);
		person2.setName("TheArchitect");
		
		cachingService.save(person2);
		
		Map<Object, Object> personMatrixMap12 = cachingService.findAll();
		
		System.out.println("Currently in the Redis Matrix"+  personMatrixMap12);
		 System.out.println(cachingService.findAll());
		 System.out.println(cachingService.findAll());
		System.out.println( cachingService.findAll());
		
		 cachingService.getInfoMessage();
		((ConfigurableApplicationContext)ctx).close();

	}

}
