package edu.helpal.datar.gbiggy.framework.datamodel;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Action Operators BD => Long, <K,V>, File, ... 
 * 
 */
public class Action {
	
	public Map<Long, String> Count(Map<Long, String> content){
		Map<String, Long> result = new HashMap<String, Long>();
		for (String item : content.values()){
			if (result.containsKey(item)){
				result.put(item, result.get(item)+1);
			}
			else{
				result.put(item, (long) 1);
			}
		} 
		content = new HashMap<Long, String>();
		long id = 0;
		for (Map.Entry<String, Long> entry : result.entrySet()){
			content.put(id, entry.getKey()+"="+entry.getValue());
			id +=1;
		}
		return content;
	}

}
