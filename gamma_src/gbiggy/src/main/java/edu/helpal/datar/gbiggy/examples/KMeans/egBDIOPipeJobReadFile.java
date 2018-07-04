package edu.helpal.datar.gbiggy.examples.KMeans;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class egBDIOPipeJobReadFile {
	public void startReadFile(BigData bigdata) {
    	new fileBD(bigdata).ReadFromFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\KMeans\\data\\egPoints.txt");
    	//new fileBD(bigdata).ReadFromFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\Exps\\data\\KMeans1M.txt");
    	//bigdata.Show();
	}
}
