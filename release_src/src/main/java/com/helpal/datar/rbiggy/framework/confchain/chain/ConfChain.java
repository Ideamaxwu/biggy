package com.helpal.datar.rbiggy.framework.confchain.chain;

import java.util.HashMap;
import java.util.Map;

import com.helpal.datar.rbiggy.bigo.InstanceBDMS;
import com.helpal.datar.rbiggy.engines.computation.ComputationEngineConf;
import com.helpal.datar.rbiggy.engines.control.ha.ControlEngineZooKeeper;
import com.helpal.datar.rbiggy.engines.control.locking.ControlEngineChubby;
import com.helpal.datar.rbiggy.engines.control.rm.ControlEngineYARN;
import com.helpal.datar.rbiggy.engines.input.InputEngineConf;
import com.helpal.datar.rbiggy.engines.output.OutputEngineConf;
import com.helpal.datar.rbiggy.engines.storage.StorageEngineConf;
import com.helpal.datar.rbiggy.framework.confchain.cores.ComputationEngine;
import com.helpal.datar.rbiggy.framework.confchain.cores.ControlEngine;
import com.helpal.datar.rbiggy.framework.confchain.cores.IEngine;
import com.helpal.datar.rbiggy.framework.confchain.cores.InputEngine;
import com.helpal.datar.rbiggy.framework.confchain.cores.OutputEngine;
import com.helpal.datar.rbiggy.framework.confchain.cores.StorageEngine;

/**
 * 
 * Configuration Chain
 *
 */
public class ConfChain {
	public void config(InstanceBDMS bigo){
		System.out.println("\n->->->   start ConfChain");
		//engines configuration
        EngineConfig conf = new EngineConfig();
		Map<String, String> engineMap = new HashMap<String, String>();
		engineMap = conf.getEngineConf();
	
    	//add Control module
    	System.out.println("\n->   add Control fisrt");
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
    	System.out.println("\n->   add Input");
    	String confInputEngineName = (String) engineMap.get("inputEngine");
    	IEngine inputEngineConf = new InputEngineConf(new InputEngine(), confInputEngineName);
    	bigo.addEngine(inputEngineConf);
    	
    	//add Storage Conf
    	System.out.println("\n->   add Storage");
    	String confStorageEngineName = (String) engineMap.get("storageEngine");
    	IEngine storageEngineConf = new StorageEngineConf(new StorageEngine(), confStorageEngineName);
    	bigo.addEngine(storageEngineConf);
    	
    	//add Computation Conf
    	System.out.println("\n->   add Computation");
    	String confComputationEngineName = (String) engineMap.get("computationEngine");
    	IEngine computationEngineConf = new ComputationEngineConf(new ComputationEngine(), confComputationEngineName);
    	bigo.addEngine(computationEngineConf);
    	
    	//add Output Conf
    	System.out.println("\n->   add Output");
    	String confOutputeEngineName = (String) engineMap.get("outputEngine");
    	IEngine outputEngineConf = new OutputEngineConf(new OutputEngine(), confOutputeEngineName);
    	bigo.addEngine(outputEngineConf);
    	
    	//show current engines
    	System.out.println("\n->   show Info");
    	bigo.showInfo();
	}
}
