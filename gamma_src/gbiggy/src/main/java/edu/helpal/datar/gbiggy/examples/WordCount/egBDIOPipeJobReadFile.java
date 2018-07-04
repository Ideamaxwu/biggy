package edu.helpal.datar.gbiggy.examples.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class egBDIOPipeJobReadFile {
	public void startReadFile(BigData bigdata) {
    	new fileBD(bigdata).ReadFromFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\WordCount\\data\\egDBcount.txt");
    	//new fileBD(bigdata).ReadFromFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\Exps\\data\\WordCountData100K.txt");
    	//bigdata.Show();
	}
}
