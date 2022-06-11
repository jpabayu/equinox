package org.equinox.api.cache;

import com.hazelcast.core.HazelcastInstance;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.core.IMap;

public class HazelcastStore implements Callable {

	@Autowired
	private HazelcastInstance instance;

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		@SuppressWarnings("unchecked")
		HashMap<String, Object> payload = (HashMap<String, Object>) eventContext.getMessage().getPayload();
		String method = (String) payload.get("methodType");
		if (method.equals("PUT")) {
			String mapName = (String) payload.get("name");
			String key = (String) payload.get("key");
			Object value = payload.get("value");
			Integer ttl = (Integer)payload.get("ttl");
			
			if(ttl == null || ttl < 1) {
				this.putCache(mapName, key, value);
			} else {
				this.putCache(mapName, key, value, ttl);
			}
			
			return null;
		} else if (method.equals("GET")) {
			String mapName = (String) payload.get("name");
			String key = (String) payload.get("key");
			return this.getCache(mapName, key);
		} else if (method.equals("REMOVE")) {
			String mapName = (String) payload.get("name");
			String key = (String) payload.get("key");
			return this.removeCache(mapName, key);
		} else if (method.equals("DELETE")) {
			String mapName = (String) payload.get("name");
			String key = (String) payload.get("key");
			this.deleteCache(mapName, key);
			return null;
		} else {
			throw new Exception("INVALID_METHOD");
		}
	}

	public void putCache(String mapName, String key, Object value) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		cacheMap.set(key, value);
	}
	
	public void putCache(String mapName, String key, Object value, int seconds) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		cacheMap.set(key, value, seconds, TimeUnit.SECONDS);
		
	}
	
	public Object getCache(String mapName, String key) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		return cacheMap.get(key);
	}
	
	public <T extends Object> T getCache(String mapName, String key, Class<T> c) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		Object result =  cacheMap.get(key);
		
		if(result != null) {
            return c.cast(result);
        }
        
        return null;
    }

	public Object removeCache(String mapName, String key) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		return cacheMap.remove(key);
	}
	
	public void deleteCache(String mapName, String key) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		cacheMap.delete(key);
	}

	public HazelcastInstance getInstance() {
		return instance;
	}

	public void setInstance(HazelcastInstance instance) {
		this.instance = instance;
	}

}
