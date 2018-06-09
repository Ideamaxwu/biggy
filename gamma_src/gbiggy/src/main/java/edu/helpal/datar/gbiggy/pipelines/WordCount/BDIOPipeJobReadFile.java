package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.BDIO;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class BDIOPipeJobReadFile {
	public void startReadFile() {
		BigData bigdata = new BigData("BigData");
    	new BDIO(bigdata).ReadFromFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\data\\DBcount.txt");
    	bigdata.Show();
	}
}
