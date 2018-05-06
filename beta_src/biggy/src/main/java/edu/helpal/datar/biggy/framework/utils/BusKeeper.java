package edu.helpal.datar.biggy.framework.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * BusKeeper
 *
 */
public class BusKeeper {
	
	private Map<String, String> context = null;
	
	public void start(){
		context = new HashMap<String, String>();
		System.out.println("Bus Keeper starting...");
		System.out.println("Restore biggy project helpal.bdms...");
	}
	
	public void close(){
		System.out.println("biggy project helpal.bdms context saved.");
		System.out.println("Bus Keeper closed.");
	}
	
	public void setContext(String key, String value){
		context.put(key, value);
	}
	
	public Map<String, String> getContext(){
		return context;
	}
}
