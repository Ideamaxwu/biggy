package com.helpal.datar.rbiggy.framework.datamodel;

import java.util.HashMap;
import java.util.Map;

import com.helpal.datar.rbiggy.examples.KMeans.egSparkPipeJobClusterTask001;
import com.helpal.datar.rbiggy.examples.PageRank.egSparkPipeJobPageRankTask001;
import com.helpal.datar.rbiggy.examples.WordCount.egSparkPipeJobWordCountTask001;

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
	
	public Map<Long, String> WordCount(Map<Long, String> content){
		System.out.println("/***   Spark WordCount Action   ***/");
		content = new egSparkPipeJobWordCountTask001().run(content);
		return content;
	}
	
	public Map<Long, String> Cluster(Map<Long, String> content){
		System.out.println("/***   Spark Cluster Action   ***/");
		content = new egSparkPipeJobClusterTask001().run(content);
		return content;
	}

	public Map<Long, String> PageRank(Map<Long, String> content) {
		System.out.println("/***   Spark PageRank Action   ***/");
		content = new egSparkPipeJobPageRankTask001().run(content);
		return content;
	}

}
