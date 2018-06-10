package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.BDIO;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class SparkPipeJobWordCount {
	public void startWordCount(BigData bigdata) {
		bigdata.Action("Count");
		bigdata.Show();
    	new BDIO(bigdata.getBD()).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\data\\DBcount_count.txt");
    	bigdata.Show();
	}
}
