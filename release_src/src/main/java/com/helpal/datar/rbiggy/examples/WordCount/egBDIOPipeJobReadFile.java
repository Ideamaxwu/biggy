package com.helpal.datar.rbiggy.examples.WordCount;

import com.helpal.datar.rbiggy.framework.datamodel.fileBD;
import com.helpal.datar.rbiggy.framework.datamodel.BigData;

public class egBDIOPipeJobReadFile {
	public void startReadFile(BigData bigdata) {
    	new fileBD(bigdata).ReadFromFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\WordCount\\data\\egDBcount.txt");
    	bigdata.Show();
	}
}
