package edu.helpal.datar.gbiggy.examples.Sort;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;
import edu.helpal.datar.gbiggy.framework.datamodel.hdfsBD;

public class egHBasePipeJobWriteDB {
	public void startWriteFile(BigData bigdata) {
    	//new fileBD(bigdata).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\Sort\\data\\egNameSort_DB.txt");
    	new hdfsBD(bigdata).WriteToHBase("Table_NameSort");
    	//bigdata.Show();
	}
}
