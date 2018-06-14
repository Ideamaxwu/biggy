package edu.helpal.datar.gbiggy.framework.datamodel;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * BigData IO Generic
 * @param <V>
 * @param <K>
 *
 */

public class BDIO<K, V> {
	private BigData bigdata;

	public BDIO(BigData bigdata) {
		this.bigdata = bigdata;
	}
	
	// to BigData type from * types
	void ToBD(Map<K,V> data){
		for (Map.Entry<K, V> entry : data.entrySet()){
			this.bigdata.content.put((Long) entry.getKey(), (String) entry.getValue());
		}
	}
	
	@SuppressWarnings("unchecked")
	//from BigData type to * types
	Map<K, V> FromBD(){
		Map<Long, String> data = new HashMap<Long, String>();
		for (Entry<Long, String> entry : bigdata.content.entrySet()){
			data.put(entry.getKey(), entry.getValue());
		}
		return (Map<K, V>) data;
	}
}
