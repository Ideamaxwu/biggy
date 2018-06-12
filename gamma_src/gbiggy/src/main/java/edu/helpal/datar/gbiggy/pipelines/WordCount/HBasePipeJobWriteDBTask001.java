package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.util.Map;
import java.util.Map.Entry;

public class HBasePipeJobWriteDBTask001 {

	public void flush(Map<Long, String> content, String tableName) {
		for (Entry<Long, String> entry : content.entrySet()){
			System.out.println("Tuple inserted to HBase["+ tableName +"]: "+ entry.getValue());
		}
		
	}
}
