package com.helpal.datar.rbiggy.examples.Sort;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.datamodel.bdio.fileBD;
import com.helpal.datar.rbiggy.framework.datamodel.bdio.hdfsBD;

public class egHBasePipeJobWriteDB {
	public void startWriteDB(BigData bigdata) {
    	new fileBD(bigdata).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\Sort\\data\\egNameSort_DB.txt");
    	new hdfsBD(bigdata).WriteToHBase("Table_NameSort");
    	bigdata.Show();
	}
}
