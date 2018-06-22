package edu.helpal.datar.gbiggy.examples.KMeans;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class egSparkPipeJobCluster {
	public void startWordCount(BigData bigdata) {
		bigdata.Action("Cluster");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\KMeans\\data\\egPoints_cluster.txt");
    	bigdata.Show();
	}
}
