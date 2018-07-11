package com.helpal.datar.rbiggy.examples.WordCount;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.datamodel.bdio.fileBD;

public class egSparkPipeJobWordCount {
	public void startCompute(BigData bigdata) {
		bigdata.Action("WordCount", "com.helpal.datar.rbiggy.examples.WordCount.egSparkPipeJobWordCountTask001");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\WordCount\\data\\egDBcount_count.txt");
    	bigdata.Show();
	}
}
