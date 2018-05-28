package edu.helpal.datar.gbiggy.bigo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import edu.helpal.datar.gbiggy.framework.utils.EngineConfig;
import edu.helpal.datar.gbiggy.framework.utils.BusKeeper;
import edu.helpal.datar.gbiggy.framework.utils.JetBrain;
import edu.helpal.datar.gbiggy.framework.inception.Inception;
import edu.helpal.datar.gbiggy.bigo.InstanceBDMS;

import edu.helpal.datar.gbiggy.framework.cores.IEngine;

import edu.helpal.datar.gbiggy.framework.cores.InputEngine;
import edu.helpal.datar.gbiggy.engines.input.InputEngineConf;
import edu.helpal.datar.gbiggy.framework.cores.StorageEngine;
import edu.helpal.datar.gbiggy.engines.storage.StorageEngineConf;
import edu.helpal.datar.gbiggy.framework.cores.ComputationEngine;
import edu.helpal.datar.gbiggy.engines.computation.ComputationEngineConf;
import edu.helpal.datar.gbiggy.framework.cores.OutputEngine;
import edu.helpal.datar.gbiggy.engines.output.OutputEngineConf;

import edu.helpal.datar.gbiggy.framework.cores.ControlEngine;
import edu.helpal.datar.gbiggy.engines.control.ha.ControlEngineZooKeeper;
import edu.helpal.datar.gbiggy.engines.control.locking.ControlEngineChubby;
import edu.helpal.datar.gbiggy.engines.control.rm.ControlEngineYARN;






/**
 * @author DWBI 1deamaxwu
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
    	incp.start();
    			
    	//buskeeper info
    	System.out.println("\n->->->   close ALL");
    	bk.setContext("endTime", new Date().toString());
    	System.out.println("biggy Context: " + bk.getContext().toString());
    	//close buskeeper
    	bk.close();
    }
}
