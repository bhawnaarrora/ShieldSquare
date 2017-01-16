package com.memorynotfound;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Statistics;

@Service
@EnableCaching
public class CachingService {
	
	@Autowired 
	RedisTemplate redisTemplate;

	@Cacheable(value = "messageCache")
	public Map<Object, Object> findAll() {
		System.out.println("Fetching Data");
		return redisTemplate.opsForHash().entries("Person1");
	}
	
	@CacheEvict(allEntries = true, value = { "messageCache" })
	@Scheduled(fixedDelay = 10 * 60 * 1000, initialDelay = 5000)
	public void reportCacheEvict() {
		System.out.println("Flush Cache ");
	}
	
	public void save(Employee person) {
		redisTemplate.opsForHash().put("Person1", person.getId(), person.toString());
	}
	
	public void getInfoMessage(){
		Cache cache = net.sf.ehcache.CacheManager.newInstance().getCache("messageCache");
		System.out.println(cache.getStatistics().cacheHitCount());
	}
}
