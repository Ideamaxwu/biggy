package com.helpal.datar.rbiggy.examples.PageRank;

import com.helpal.datar.rbiggy.framework.datamodel.fileBD;
import com.helpal.datar.rbiggy.framework.datamodel.BigData;

public class egSparkPipeJobPageRank {
	public void startCompute(BigData bigdata) {
		bigdata.Action("PageRank");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\PageRank\\data\\egGraph_PR.txt");
    	bigdata.Show();
	}
}
