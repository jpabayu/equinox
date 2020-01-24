package org.equinox.api.process;

import java.util.HashMap;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class CacheProcessor implements Callable {

	private HazelcastInstance instance;

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		@SuppressWarnings("unchecked")

		HashMap<String, Object> payload = (HashMap<String, Object>) eventContext.getMessage().getPayload();
		String method = (String) payload.get("methodType");
		if (method.equalsIgnoreCase("PUT")) {
			String mapName = (String) payload.get("name");
			String key = (String) payload.get("key");
			Object value = payload.get("value");
			this.putCache(mapName, key, value);
			return null;
		} else if (method.equalsIgnoreCase("GET")) {
			String mapName = (String) payload.get("name");
			String key = (String) payload.get("key");
			return this.getCache(mapName, key);
		} else if (method.equalsIgnoreCase("DELETE")) {
			String mapName = (String) payload.get("name");
			String key = (String) payload.get("key");
			this.removeCache(mapName, key);
			return null;
		} else {
			throw new Exception("INVALID_METHOD");
		}
	}

	public void putCache(String mapName, String key, Object value) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		cacheMap.put(key, value);
	}

	public Object getCache(String mapName, String key) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		return cacheMap.get(key);
	}

	public void removeCache(String mapName, String key) {
		IMap<String, Object> cacheMap = instance.getMap(mapName);
		cacheMap.remove(key);
	}

	public HazelcastInstance getInstance() {
		return instance;
	}

	public void setInstance(HazelcastInstance instance) {
		this.instance = instance;
	}

}
