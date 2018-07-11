package com.helpal.datar.rbiggy.bigo;


import com.helpal.datar.rbiggy.bigo.InstanceBDMS;

import com.helpal.datar.rbiggy.framework.confchain.chain.ConfChain;
import com.helpal.datar.rbiggy.framework.pipeline.Pipeline;
import com.helpal.datar.rbiggy.framework.datamodel.BigData;

/**
 * @author HelPal 1deamaxwu
 * @version r
 * 
 * biggy: All Fit in One, A Unified Framework for Big Data Management System
 *
 */
public class biggy 
{
    public static void main( String[] args )
    {
    	//start instance
		System.out.println("->->->   start Bigo");
    	InstanceBDMS bigo = InstanceBDMS.getInstance();
    	
    	//bundle intelligence
    	bigo.bundleContext();
    	bigo.startIntelySys();
    	
    	//config engines
    	ConfChain confchain = new ConfChain();
    	confchain.config(bigo);
    	
    	//run pipeline model
    	System.out.println("\n->->->   start Pipeline");
    	Pipeline pipeline = new Pipeline();
    	pipeline.run();
    	
    	//data model
    	System.out.println("\n->->->   BigData Model");
    	BigData bigdata = new BigData("BigData");
    	bigdata.Show();
    	bigdata.Tansform("upperCase");
    	bigdata.Show();
    	
    	//start bigo server
    	System.out.println("\n->->->   start bigo server");
    	bigo.startServer();
    }
}
