package com.helpal.datar.rbiggy.examples.KMeans;

import com.helpal.datar.rbiggy.framework.datamodel.fileBD;
import com.helpal.datar.rbiggy.framework.datamodel.BigData;

public class egSparkPipeJobCluster {
	public void startWordCount(BigData bigdata) {
		bigdata.Action("Cluster");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\KMeans\\data\\egPoints_cluster.txt");
    	bigdata.Show();
	}
}
