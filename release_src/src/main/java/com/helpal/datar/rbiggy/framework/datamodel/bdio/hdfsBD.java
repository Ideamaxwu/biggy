package com.helpal.datar.rbiggy.framework.datamodel.bdio;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.pipelines.utils.HBasePipeJobWriteDBTaskUtil;

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
		new HBasePipeJobWriteDBTaskUtil().flush(this.bigdata.getContent(), tablename);
	}

}
