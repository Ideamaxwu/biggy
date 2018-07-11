package com.helpal.datar.rbiggy.framework.datamodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Transform Operators BD<T> => BD<T>, BD<T> => BD<U>
 * 
 */
public class Transform {

	public Map<Long, String> Sort(Map<Long, String> content, String cls) {
		System.out.println("/***   Aabcus Sort Action   ***/");
		Map<Long, String> resultMap = sortMapByValue(content); 
		long id = 0;
		
		for (Entry<Long, String> entry : resultMap.entrySet()){
			content.put(id, entry.getValue());
			id +=1;
		}
		
		return content;
	}
	
	public Map<Long, String> Filter(Map<Long, String> content, String filter) {
		
		Map<Long, String> result = new HashMap<Long, String>();
		long id = 0;
		for(Entry<Long, String> entry : content.entrySet()){
			if(entry.getValue().contains(filter)){
				result.put(id, entry.getValue());
				id += 1;
			}
		}
		
		return result;
	}

	public Map<Long, String> sortMapByValue(Map<Long, String> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		Map<Long, String> sortedMap = new LinkedHashMap<Long, String>();
		List<Map.Entry<Long, String>> entryList = new ArrayList<Map.Entry<Long, String>>(oriMap.entrySet());
		Collections.sort(entryList, new MapValueComparator());

		Iterator<Map.Entry<Long, String>> iter = entryList.iterator();
		Map.Entry<Long, String> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}
}

class MapValueComparator implements Comparator<Map.Entry<Long, String>> {

	@Override
	public int compare(Entry<Long, String> me1, Entry<Long, String> me2) {

		return me1.getValue().compareTo(me2.getValue());
	}
}
