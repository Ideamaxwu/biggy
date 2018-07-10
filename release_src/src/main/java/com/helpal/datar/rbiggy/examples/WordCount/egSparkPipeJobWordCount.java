package com.helpal.datar.rbiggy.examples.WordCount;

import com.helpal.datar.rbiggy.framework.datamodel.fileBD;
import com.helpal.datar.rbiggy.framework.datamodel.BigData;

public class egSparkPipeJobWordCount {
	public void startCompute(BigData bigdata) {
		bigdata.Action("WordCount");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\WordCount\\data\\egDBcount_count.txt");
    	bigdata.Show();
	}
}
