package edu.helpal.datar.gbiggy.framework.datamodel;

import edu.helpal.datar.gbiggy.pipelines.WordCount.HBasePipeJobWriteDBTask001;

public class hdfsBD {
	private BigData bigdata;

	public hdfsBD(BigData bigdata) {
		this.bigdata = bigdata;
	}

	public void WriteToHBase(String tablename) {
		
		System.out.println("Write to HBase Table: " + tablename);
		new HBasePipeJobWriteDBTask001().flush(this.bigdata.content, tablename);
	}

}
