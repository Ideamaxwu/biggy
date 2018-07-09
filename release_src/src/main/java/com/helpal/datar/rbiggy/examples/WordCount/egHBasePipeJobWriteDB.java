package com.helpal.datar.rbiggy.examples.WordCount;

import com.helpal.datar.rbiggy.framework.datamodel.fileBD;
import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.datamodel.hdfsBD;

public class egHBasePipeJobWriteDB {
	public void startWriteFile(BigData bigdata) {
    	new fileBD(bigdata).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\WordCount\\data\\egDBcount_DB.txt");
    	new hdfsBD(bigdata).WriteToHBase("Table_DBcount");
    	bigdata.Show();
	}
}
