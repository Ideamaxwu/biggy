package edu.helpal.datar.biggy.framework.cores;

import java.util.Map;
import java.util.HashMap;

import edu.helpal.datar.biggy.framework.inception.Inception;
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
		Map engineMap = new HashMap();
		engineMap = conf.getEngineConf();
		
		InstanceObject bigo = InstanceObject.getInstance();
		//test instance duplicate
		InstanceObject bigoCopy = InstanceObject.getInstance();
		
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
    }
}
