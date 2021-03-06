package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;
import edu.helpal.datar.gbiggy.framework.datamodel.hdfsBD;

public class HBasePipeJobWriteDB {
	public void startWriteFile(BigData bigdata) {
    	new fileBD(bigdata).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\data\\DBcount_DB.txt");
    	new hdfsBD(bigdata).WriteToHBase("Table_DBcount");
    	bigdata.Show();
	}
}
