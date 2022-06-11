package org.equinox.api.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.log4j.Logger;

public class Configuration {
	
	private static final Object lock = new Object();
	private static volatile Configuration config;
	private final static Logger logger = Logger.getLogger(Configuration.class);
	private HashMap<String, String> propsMap;
	
	private Configuration() {
		propsMap = new HashMap<String, String>();
		
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
		    fis = new FileInputStream(System.getProperty("mule.home")+"/apps/equinox/mule-app.properties");
		    prop.load(fis);
		    String env = prop.getProperty("mule.env");
		    fis.close();
		    
		    prop = new Properties();
		    fis = new FileInputStream(System.getProperty("mule.home")+"/apps/equinox/classes/"+env+".properties");
		    prop.load(fis);
		    loadConfig(prop);
		} catch (Exception e) {
			logger.error("Configuration is failed to load -> " + e.getMessage());
		} finally {
		    if (fis != null) {
		        try {
		            fis.close();
		        }
		        catch (Exception e) {}
		    }
		}
	}
	
	private void loadConfig(Properties prop) {
		Set<Entry<Object, Object>> entries = prop.entrySet();
	    for (Entry<Object, Object> entry : entries) {
	    	propsMap.put(entry.getKey().toString(), entry.getValue().toString());
	    }
		
		if(logger.isInfoEnabled()){
            logger.info("Configuration loaded successfully");
        }
	}
	
	public static Configuration getInstance() { 
		Configuration conf = config;
    	if (conf == null) {
	        synchronized (lock) { 
	        	conf = config;
	            if (conf == null) {  
	            	conf = new Configuration();
	            	config = conf;
	            }
	        }
	    }
		
        return config;
    }
	
	public boolean isEmpty() {
		return propsMap.isEmpty();
	}
	
	public boolean getBoolean(Key key) {
		return getBoolean(key, false);
	}
	
	public boolean getBoolean(Key key, boolean defValue) {
		if(propsMap.containsKey(key.key())) {
			
			return Boolean.parseBoolean(propsMap.get(key.key()));
		}
		
		return defValue;
	}
	
	public int getInteger(Key key) {
		return getInteger(key, 0);
	}
	
	public int getInteger(Key key, int defValue) {
		if(propsMap.containsKey(key.key())) {
			try {
				return Integer.parseInt(propsMap.get(key.key()));
			} catch(NumberFormatException e) {
				return defValue;
			}	
		}
		
		return defValue;
	}
	
	public long getLong(Key key) {
		return getLong(key, 0);
	}
	
	public long getLong(Key key, long defValue) {
		if(propsMap.containsKey(key.key())) {
			try {
				return Long.parseLong(propsMap.get(key.key()));
			} catch(NumberFormatException e) {
				return defValue;
			}	
		}
		
		return defValue;
	}
	
	public String getString(Key key) {
		return getString(key, "");
	}
	
	public String getString(Key key, String defValue) {
		if(propsMap.containsKey(key.key())) {
			return propsMap.get(key.key());
		}
		
		return defValue;
	}
	
}
