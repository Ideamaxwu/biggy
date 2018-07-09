package com.helpal.datar.rbiggy.examples.Sort;

import com.helpal.datar.rbiggy.framework.datamodel.fileBD;
import com.helpal.datar.rbiggy.framework.datamodel.BigData;

public class egSparkPipeJobSort {
	public void startWordCount(BigData bigdata) {
		bigdata.Tansform("Sort");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\Sort\\data\\egNameSort_Sort.txt");
    	bigdata.Show();
	}
}
