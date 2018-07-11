package com.helpal.datar.rbiggy.examples.KMeans;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.datamodel.bdio.fileBD;

public class egBDIOPipeJobReadFile {
	public void startReadFile(BigData bigdata) {
    	new fileBD(bigdata).ReadFromFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\KMeans\\data\\egPoints.txt");
    	bigdata.Show();
	}
}
