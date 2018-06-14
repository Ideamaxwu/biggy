package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class BDIOPipeJobReadFile {
	public void startReadFile(BigData bigdata) {
    	new fileBD(bigdata).ReadFromFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\data\\DBcount.txt");
    	bigdata.Show();
	}
}
