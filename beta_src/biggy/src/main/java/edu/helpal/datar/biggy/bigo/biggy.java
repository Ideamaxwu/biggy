package edu.helpal.datar.biggy.bigo;

import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import edu.helpal.datar.biggy.framework.cores.ComputationEngine;
import edu.helpal.datar.biggy.framework.cores.ComputationEngineSpark;
import edu.helpal.datar.biggy.framework.cores.ControlEngine;
import edu.helpal.datar.biggy.framework.cores.ControlEngineYARN;
import edu.helpal.datar.biggy.framework.cores.Engine;
import edu.helpal.datar.biggy.framework.cores.InputEngine;
import edu.helpal.datar.biggy.framework.cores.InputEngineConf;
import edu.helpal.datar.biggy.framework.cores.OutputEngine;
import edu.helpal.datar.biggy.framework.cores.OutputEngineConf;
import edu.helpal.datar.biggy.framework.cores.StorageEngine;
import edu.helpal.datar.biggy.framework.cores.StorageEngineHBase;
import edu.helpal.datar.biggy.framework.inception.Inception;
import edu.helpal.datar.biggy.framework.utils.BusKeeper;
import edu.helpal.datar.biggy.framework.utils.Configuration;

/**
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
		
		InstanceObject bigo = InstanceObject.getInstance();
		//test instance duplicate
		InstanceObject.getInstance();
		
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
		
		//add Control YARN
		Engine controlEngineYARN = new ControlEngineYARN(new ControlEngine());
		bigo.addEngine(controlEngineYARN);
		
		//add Out Conf
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
