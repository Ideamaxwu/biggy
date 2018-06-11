package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.util.HashMap;
import java.util.Map;

public class SparkPipeJobWordCountTask001 {
	public Map<Long, String> run(Map<Long, String> content){
		System.out.println("/***   SparkCount TEST Task   ***/");
		Map<Long, String> result = new HashMap<Long, String>();
		result.put((long) -1, "SparkCountTest");
		
		content = result;
		return content;
	}
}
