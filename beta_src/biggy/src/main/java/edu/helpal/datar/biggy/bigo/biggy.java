package edu.helpal.datar.biggy.bigo;

import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import edu.helpal.datar.biggy.engines.computation.ComputationEngineSpark;
import edu.helpal.datar.biggy.engines.control.ha.ControlEngineZooKeeper;
import edu.helpal.datar.biggy.engines.control.locking.ControlEngineChubby;
import edu.helpal.datar.biggy.engines.control.rm.ControlEngineYARN;
import edu.helpal.datar.biggy.engines.input.InputEngineConf;
import edu.helpal.datar.biggy.engines.output.OutputEngineConf;
import edu.helpal.datar.biggy.engines.storage.StorageEngineHBase;
import edu.helpal.datar.biggy.framework.cores.ComputationEngine;
import edu.helpal.datar.biggy.framework.cores.ControlEngine;
import edu.helpal.datar.biggy.framework.cores.IEngine;
import edu.helpal.datar.biggy.framework.cores.InputEngine;
import edu.helpal.datar.biggy.framework.cores.OutputEngine;
import edu.helpal.datar.biggy.framework.cores.StorageEngine;
import edu.helpal.datar.biggy.framework.inception.Inception;
import edu.helpal.datar.biggy.framework.pipeline.Pipeline;
import edu.helpal.datar.biggy.framework.utils.BusKeeper;
import edu.helpal.datar.biggy.framework.utils.EngineConfig;
import edu.helpal.datar.biggy.framework.utils.JetBrain;

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
        EngineConfig conf = new EngineConfig();
		Map<String, String> engineMap = new HashMap<String, String>();
		engineMap = conf.getEngineConf();
		
		//bus keeper
		BusKeeper bk = new BusKeeper();
		bk.start();
		bk.setContext("startTime", new Date().toString());
		
		//jet brain
		JetBrain jb = new JetBrain();
		jb.start();
		
		//start instance
		InstanceBDMS bigo = InstanceBDMS.getInstance();
		//test instance duplicate
		InstanceBDMS.getInstance();
		
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
		String confInputeEngineName = (String) engineMap.get("inputEngine");
		IEngine inputEngineConf = new InputEngineConf(new InputEngine(), confInputeEngineName);
		bigo.addEngine(inputEngineConf);
		
		//add Storage HBase
		IEngine storageEngineHBase = new StorageEngineHBase(new StorageEngine());
		bigo.addEngine(storageEngineHBase);
		
		//add Computation Spark
		IEngine computationEngineSpark = new ComputationEngineSpark(new ComputationEngine());
		bigo.addEngine(computationEngineSpark);
		
		//add Output Conf
		String confOutputeEngineName = (String) engineMap.get("outputEngine");
		IEngine outputEngineConf = new OutputEngineConf(new OutputEngine(), confOutputeEngineName);
		bigo.addEngine(outputEngineConf);
		
		//show current engines
		bigo.showInfo();
		
		//start cmd line
		Inception incp = new Inception();
		incp.start();
		
		//run pipeline
		Pipeline pipeline = new Pipeline();
		pipeline.run();
		
		//buskeeper info
		bk.setContext("endTime", new Date().toString());
		System.out.println("biggy Context: " + bk.getContext().toString());
		//close buskeeper
		bk.close();
    }
}
