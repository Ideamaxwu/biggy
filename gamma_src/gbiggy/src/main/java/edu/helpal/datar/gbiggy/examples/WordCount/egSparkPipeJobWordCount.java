package edu.helpal.datar.gbiggy.examples.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class egSparkPipeJobWordCount {
	public void startWordCount(BigData bigdata) {
		bigdata.Action("WordCount");
    	//new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\WordCount\\data\\egDBcount_count.txt");
    	//bigdata.Show();
	}
}
