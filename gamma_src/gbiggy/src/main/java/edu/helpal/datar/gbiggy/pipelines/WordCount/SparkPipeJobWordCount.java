package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class SparkPipeJobWordCount {
	public void startWordCount(BigData bigdata) {
		bigdata.Action("Count");
		bigdata.Show();
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\data\\DBcount_count.txt");
    	bigdata.Show();
    	bigdata.Action("SparkCount");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\data\\DBcount_sparkcount.txt");
    	bigdata.Show();
	}
}
