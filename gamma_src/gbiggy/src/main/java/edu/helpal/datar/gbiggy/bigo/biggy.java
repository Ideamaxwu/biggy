package edu.helpal.datar.gbiggy.bigo;

import java.util.HashMap;
import java.util.Map;

import edu.helpal.datar.gbiggy.framework.utils.EngineConfig;
import edu.helpal.datar.gbiggy.bigo.InstanceBDMS;
import edu.helpal.datar.gbiggy.engines.input.InputEngineConf;
import edu.helpal.datar.gbiggy.framework.cores.IEngine;
import edu.helpal.datar.gbiggy.framework.cores.InputEngine;

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
    	
    	//start instance
    	InstanceBDMS bigo = InstanceBDMS.getInstance();
    	//test instance duplicate
    	InstanceBDMS.getInstance();
    	
    	//add Input Conf
    	String confInputeEngineName = (String) engineMap.get("inputEngine");
    	IEngine inputEngineConf = new InputEngineConf(new InputEngine(), confInputeEngineName);
    	bigo.addEngine(inputEngineConf);
    }
}
