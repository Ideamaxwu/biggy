package com.helpal.datar.rbiggy.bigo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.helpal.datar.rbiggy.bigo.InstanceBDMS;
import com.helpal.datar.rbiggy.framework.utils.EngineConfig;
import com.helpal.datar.rbiggy.framework.utils.BusKeeper;
import com.helpal.datar.rbiggy.framework.utils.JetBrain;
import com.helpal.datar.rbiggy.framework.inception.Inception;
import com.helpal.datar.rbiggy.framework.pipeline.Pipeline;

import com.helpal.datar.rbiggy.framework.cores.IEngine;
import com.helpal.datar.rbiggy.framework.cores.ControlEngine;
import com.helpal.datar.rbiggy.engines.control.ha.ControlEngineZooKeeper;
import com.helpal.datar.rbiggy.engines.control.locking.ControlEngineChubby;
import com.helpal.datar.rbiggy.engines.control.rm.ControlEngineYARN;
import com.helpal.datar.rbiggy.framework.cores.InputEngine;
import com.helpal.datar.rbiggy.engines.input.InputEngineConf;
import com.helpal.datar.rbiggy.framework.cores.StorageEngine;
import com.helpal.datar.rbiggy.engines.storage.StorageEngineConf;
import com.helpal.datar.rbiggy.framework.cores.ComputationEngine;
import com.helpal.datar.rbiggy.engines.computation.ComputationEngineConf;
import com.helpal.datar.rbiggy.framework.cores.OutputEngine;
import com.helpal.datar.rbiggy.engines.output.OutputEngineConf;

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
    	//engines configuration
        EngineConfig conf = new EngineConfig();
		Map<String, String> engineMap = new HashMap<String, String>();
		engineMap = conf.getEngineConf();
    	
		//bus keeper
		System.out.println("\n->->->   start BusKeeper");
		BusKeeper bk = new BusKeeper();
		bk.start();
		bk.setContext("startTime", new Date().toString());
				
		//jet brain
		System.out.println("\n->->->   start JetBrain");
		JetBrain jb = new JetBrain();
		jb.start();
				
    	//start instance
		System.out.println("\n->->->   start Bigo");
    	InstanceBDMS bigo = InstanceBDMS.getInstance();
    	//test instance duplicate
    	InstanceBDMS.getInstance();
    	bigo.bundleContext(bk);
    	
    	//add Control module
    	System.out.println("\n->->->   add Control fisrt");
    	//add Control high availability ZooKeeper
    	IEngine controlEngineZK = new ControlEngineZooKeeper(new ControlEngine());
    	bigo.addEngine(controlEngineZK);
    	//add Control resource manager YARN
    	IEngine controlEngineYARN = new ControlEngineYARN(new ControlEngine());
    	bigo.addEngine(controlEngineYARN);
    	//add Control locking Chubby
    	IEngine controlEngineChubby = new ControlEngineChubby(new ControlEngine());
    	bigo.addEngine(controlEngineChubby);
    	
    	//add Input Conf
    	System.out.println("\n->->->   add Input");
    	String confInputEngineName = (String) engineMap.get("inputEngine");
    	IEngine inputEngineConf = new InputEngineConf(new InputEngine(), confInputEngineName);
    	bigo.addEngine(inputEngineConf);
    	
    	//add Storage Conf
    	System.out.println("\n->->->   add Storage");
    	String confStorageEngineName = (String) engineMap.get("storageEngine");
    	IEngine storageEngineConf = new StorageEngineConf(new StorageEngine(), confStorageEngineName);
    	bigo.addEngine(storageEngineConf);
    	
    	//add Computation Conf
    	System.out.println("\n->->->   add Computation");
    	String confComputationEngineName = (String) engineMap.get("computationEngine");
    	IEngine computationEngineConf = new ComputationEngineConf(new ComputationEngine(), confComputationEngineName);
    	bigo.addEngine(computationEngineConf);
    	
    	//add Output Conf
    	System.out.println("\n->->->   add Output");
    	String confOutputeEngineName = (String) engineMap.get("outputEngine");
    	IEngine outputEngineConf = new OutputEngineConf(new OutputEngine(), confOutputeEngineName);
    	bigo.addEngine(outputEngineConf);
    			
    	//show current engines
    	System.out.println("\n->->->   show Info");
    	bigo.showInfo();
    	
    	//start Inception cmd line
    	System.out.println("\n->->->   start Inception");
    	Inception incp = new Inception();
    	//incp.start();
    	incp.init();
    	
    	//run pipeline model
    	System.out.println("\n->->->   start Pipeline");
    	Pipeline pipeline = new Pipeline();
    	pipeline.run();
    	
    	//start bigo server
    	System.out.println("\n->->->   start bigo server");
    	bigo.startServer();
    	
    	//buskeeper info
    	System.out.println("\n->->->   close ALL");
    	bk.setContext("endTime", new Date().toString());
    	System.out.println("biggy Context: " + bk.getContext().toString());
    	//close buskeeper
    	bk.close();
    }
}