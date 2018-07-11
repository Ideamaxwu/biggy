package com.helpal.datar.rbiggy.examples.KMeans;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.datamodel.bdio.fileBD;

public class egSparkPipeJobCluster {
	public void startCompute(BigData bigdata) {
		bigdata.Action("Cluster" ,"com.helpal.datar.rbiggy.examples.KMeans.egSparkPipeJobClusterTask001");
    	new fileBD(bigdata.getBD()).WriteToFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\KMeans\\data\\egPoints_cluster.txt");
    	bigdata.Show();
	}
}
