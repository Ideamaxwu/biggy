package edu.helpal.datar.gbiggy.examples.KMeans;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;
import edu.helpal.datar.gbiggy.framework.datamodel.hdfsBD;

public class egHBasePipeJobWriteDB {
	public void startWriteFile(BigData bigdata) {
    	new fileBD(bigdata).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\KMeans\\data\\egPoints_DB.txt");
    	new hdfsBD(bigdata).WriteToHBase("Table_Points");
    	bigdata.Show();
	}
}
