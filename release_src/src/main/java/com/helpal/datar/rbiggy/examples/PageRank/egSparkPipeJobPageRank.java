package com.helpal.datar.rbiggy.examples.PageRank;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.datamodel.bdio.fileBD;

public class egSparkPipeJobPageRank {
	public void startCompute(BigData bigdata) {
		bigdata.Action("PageRank", "com.helpal.datar.rbiggy.examples.PageRank.egSparkPipeJobPageRankTask001");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\PageRank\\data\\egGraph_PR.txt");
    	bigdata.Show();
	}
}
