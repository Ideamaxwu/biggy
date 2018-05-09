package edu.helpal.datar.biggy.bigo;

import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import edu.helpal.datar.biggy.engines.computation.ComputationEngineSpark;
import edu.helpal.datar.biggy.engines.control.ha.ControlEngineZooKeeper;
import edu.helpal.datar.biggy.engines.control.rm.ControlEngineYARN;
import edu.helpal.datar.biggy.engines.input.InputEngineConf;
import edu.helpal.datar.biggy.engines.output.OutputEngineConf;
import edu.helpal.datar.biggy.engines.storage.StorageEngineHBase;
import edu.helpal.datar.biggy.framework.cores.ComputationEngine;
import edu.helpal.datar.biggy.framework.cores.ControlEngine;
import edu.helpal.datar.biggy.framework.cores.Engine;
import edu.helpal.datar.biggy.framework.cores.InputEngine;
import edu.helpal.datar.biggy.framework.cores.OutputEngine;
import edu.helpal.datar.biggy.framework.cores.StorageEngine;
import edu.helpal.datar.biggy.framework.inception.Inception;
import edu.helpal.datar.biggy.framework.utils.BusKeeper;
import edu.helpal.datar.biggy.framework.utils.Configuration;

/**
 * @author DWBI 1deamaxwu
 * 
 * biggy
 *
 */
public class biggy 
{
    public static void main( String[] args )
    {
		//engines configuration
        Configuration conf = new Configuration();
		Map<String, String> engineMap = new HashMap<String, String>();
		engineMap = conf.getEngineConf();
		
		//bus keeper
		BusKeeper bk = new BusKeeper();
		bk.start();
		bk.setContext("startTime", new Date().toString());
		
		InstanceBDMS bigo = InstanceBDMS.getInstance();
		//test instance duplicate
		InstanceBDMS.getInstance();
		
		//add Input Conf
		String confInputeEngineName = (String) engineMap.get("inputEngine");
		Engine inputEngineConf = new InputEngineConf(new InputEngine(), confInputeEngineName);
		bigo.addEngine(inputEngineConf);
		
		//add Storage HBase
		Engine storageEngineHBase = new StorageEngineHBase(new StorageEngine());
		bigo.addEngine(storageEngineHBase);
		
		//add Computation Spark
		Engine computationEngineSpark = new ComputationEngineSpark(new ComputationEngine());
		bigo.addEngine(computationEngineSpark);
		
		//add Control resource manager YARN
		Engine controlEngineYARN = new ControlEngineYARN(new ControlEngine());
		bigo.addEngine(controlEngineYARN);
		//add Control high availability ZooKeeper
		Engine controlEngineZK = new ControlEngineZooKeeper(new ControlEngine());
		bigo.addEngine(controlEngineZK);
		
		//add Output Conf
		String confOutputeEngineName = (String) engineMap.get("outputEngine");
		Engine outputEngineConf = new OutputEngineConf(new OutputEngine(), confOutputeEngineName);
		bigo.addEngine(outputEngineConf);
		
		//show current engines
		bigo.showInfo();
		
		//start cmd line
		Inception incp = new Inception();
		incp.start();
		
		//buskeeper info
		bk.setContext("endTime", new Date().toString());
		System.out.println("biggy Context: " + bk.getContext().toString());
		//close buskeeper
		bk.close();
    }
}
