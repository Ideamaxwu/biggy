package edu.helpal.datar.gbiggy.examples.PageRank;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class egSparkPipeJobPageRank {
	public void startWordCount(BigData bigdata) {
		bigdata.Action("PageRank");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\PageRank\\data\\egGraph_PR.txt");
    	bigdata.Show();
	}
}
