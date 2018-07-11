package com.helpal.datar.rbiggy.framework.datamodel;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
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
			content.put(id, entry.getKey()+": "+entry.getValue());
			id +=1;
		}
		return content;
	} 
	
	public Map<Long, String> WordCount(Map<Long, String> content, String cls){
		System.out.println("/***   Spark WordCount Action   ***/");
		//content = new egSparkPipeJobWordCountTask001().run(content);
		Class<?> wc;
		Object obj;
		try {
			wc = Class.forName(cls);
			obj = wc.getConstructor().newInstance(); 
			Method meth = wc.getMethod("run", Map.class);
			Object result = meth.invoke(obj, content);
			content = (Map<Long, String>) result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return content;
	}
	
	public Map<Long, String> Cluster(Map<Long, String> content, String cls){
		System.out.println("/***   Spark Cluster Action   ***/");
		//content = new egSparkPipeJobClusterTask001().run(content);
		Class<?> clus;
		Object obj;
		try {
			clus = Class.forName(cls);
			obj = clus.getConstructor().newInstance(); 
			Method meth = clus.getMethod("run", Map.class);
			Object result = meth.invoke(obj, content);
			content = (Map<Long, String>) result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}

	public Map<Long, String> PageRank(Map<Long, String> content, String cls) {
		System.out.println("/***   Spark PageRank Action   ***/");
		//content = new egSparkPipeJobPageRankTask001().run(content);
		Class<?> pr;
		Object obj;
		try {
			pr = Class.forName(cls);
			obj = pr.getConstructor().newInstance(); 
			Method meth = pr.getMethod("run", Map.class);
			Object result = meth.invoke(obj, content);
			content = (Map<Long, String>) result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}

}
