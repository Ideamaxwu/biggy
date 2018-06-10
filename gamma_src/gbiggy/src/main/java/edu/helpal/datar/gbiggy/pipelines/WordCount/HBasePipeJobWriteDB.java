package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.BDIO;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class HBasePipeJobWriteDB {
	public void startWriteFile(BigData bigdata) {
    	new BDIO(bigdata).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\data\\DBcount_DB.txt");
    	bigdata.Show();
	}
}
