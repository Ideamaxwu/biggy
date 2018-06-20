package edu.helpal.datar.gbiggy.examples.Sort;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class egSparkPipeJobSort {
	public void startWordCount(BigData bigdata) {
		bigdata.Tansform("Sort");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\Sort\\data\\egNameSort_Sort.txt");
    	bigdata.Show();
	}
}
