package com.helpal.datar.rbiggy.framework.datamodel;

import com.helpal.datar.rbiggy.pipelines.WordCount.HBasePipeJobWriteDBTask001;

/**
 * 
 * BigData <=> hdfs IO
 * 
 */
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
