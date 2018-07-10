package com.helpal.datar.rbiggy.examples.KMeans;

import com.helpal.datar.rbiggy.framework.datamodel.fileBD;
import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.datamodel.hdfsBD;

public class egHBasePipeJobWriteDB {
	public void startWriteDB(BigData bigdata) {
    	new fileBD(bigdata).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\KMeans\\data\\egPoints_DB.txt");
    	new hdfsBD(bigdata).WriteToHBase("Table_Points");
    	bigdata.Show();
	}
}
